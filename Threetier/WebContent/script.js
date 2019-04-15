$(document).ready(function() {

	$('#submitfeedback').click(function(e){
		var name = $("#name").val();
		var comment = $("#comment").val();
		$.ajax({
		    type : "POST",
		    contentType : 'application/json; charset=utf-8',
		    dataType : "JSON",
		    url : 'Servlet?name='+name+'&comment='+comment,
		    success : function(data) {
		    	var tablestart = "<table border='1' id='table'><tr><th>Name</th><th>Comment</th></tr>";
		    	var tableend = "</table>";
		    	var tablemid = "";
		        $.each(data, function(i, eachdata){
		        	tablemid += "<tr><td>"+eachdata.name+"</td><td>"+eachdata.comment+"</td></tr>";
		        })
		        $("#table").html(tablestart+tablemid+tableend);
		    }
		});
	});
});
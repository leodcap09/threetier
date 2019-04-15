package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Model;

public class Persistence {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/threetier";
	static final String USER = "root";
	static final String PASS = "root";

	public List<Model> persistence(final String name, final String comment) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		List<Model> models = null;
		Model model = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(Persistence.DB_URL, Persistence.USER, Persistence.PASS);
			stmt = conn.createStatement();
			sql = "SELECT name,comment FROM feedback";
			rs = stmt.executeQuery(sql);
			models = new ArrayList<>();
			while (rs.next()) {
				model = new Model();
				model.setName(rs.getString("name"));
				model.setComment(rs.getString("comment"));
				models.add(model);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (final SQLException se) {
			se.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (final SQLException se) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (final SQLException se) {
				se.printStackTrace();
			}
		}
		return models;
	}

}

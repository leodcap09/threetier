package com.service;

import java.util.List;

import com.model.Model;
import com.persistence.Persistence;

public class Service {

	public List<Model> service(final String name, final String comment) {
		return new Persistence().persistence(name, comment);
	}

}

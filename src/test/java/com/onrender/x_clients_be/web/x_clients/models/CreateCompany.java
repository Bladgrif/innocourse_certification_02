package com.onrender.x_clients_be.web.x_clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCompany {

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	public CreateCompany setName(String name){
		this.name = name;
		return this;
	}

	public String getName(){
		return name;
	}

	public CreateCompany setDescription(String description){
		this.description = description;
		return this;
	}

	public String getDescription(){
		return description;
	}

	@Override
	public String toString() {
		return "CreateCompany{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
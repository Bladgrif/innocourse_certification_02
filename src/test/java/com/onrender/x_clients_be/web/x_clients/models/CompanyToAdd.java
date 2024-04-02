package com.onrender.x_clients_be.web.x_clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyToAdd{

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	public CompanyToAdd setName(String name){
		this.name = name;
		return this;
	}

	public String getName(){
		return name;
	}

	public CompanyToAdd setDescription(String description){
		this.description = description;
		return this;
	}

	public String getDescription(){
		return description;
	}

	@Override
	public String toString() {
		return "CompanyToAdd{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
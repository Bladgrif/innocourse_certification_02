package com.onrender.x_clients_be.web.x_clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateEmployee{

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("isActive")
	private boolean isActive;

	@JsonProperty("email")
	private String email;

	@JsonProperty("url")
	private String url;

	public UpdateEmployee setLastName(String lastName){
		this.lastName = lastName;
		return this;
	}

	public String getLastName(){
		return lastName;
	}

	public UpdateEmployee setPhone(String phone){
		this.phone = phone;
		return this;
	}

	public String getPhone(){
		return phone;
	}

	public UpdateEmployee setIsActive(boolean isActive){
		this.isActive = isActive;
		return this;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public UpdateEmployee setEmail(String email){
		this.email = email;
		return this;
	}

	public String getEmail(){
		return email;
	}

	public UpdateEmployee setUrl(String url){
		this.url = url;
		return this;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"UpdateEmployee{" + 
			"lastName = '" + lastName + '\'' + 
			",phone = '" + phone + '\'' + 
			",isActive = '" + isActive + '\'' + 
			",email = '" + email + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
package com.onrender.x_clients_be.web.x_clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmployee{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("companyId")
	private int companyId;

	@JsonProperty("birthdate")
	private String birthdate;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("middleName")
	private String middleName;

	@JsonProperty("id")
	private int id;

	@JsonProperty("isActive")
	private boolean isActive;

	@JsonProperty("email")
	private String email;

	@JsonProperty("url")
	private String url;

	public CreateEmployee setFirstName(String firstName){
		this.firstName = firstName;
		return this;
	}

	public String getFirstName(){
		return firstName;
	}

	public CreateEmployee setLastName(String lastName){
		this.lastName = lastName;
		return this;
	}

	public String getLastName(){
		return lastName;
	}

	public CreateEmployee setCompanyId(int companyId){
		this.companyId = companyId;
		return this;
	}

	public int getCompanyId(){
		return companyId;
	}

	public CreateEmployee setBirthdate(String birthdate){
		this.birthdate = birthdate;
		return this;
	}

	public String getBirthdate(){
		return birthdate;
	}

	public CreateEmployee setPhone(String phone){
		this.phone = phone;
		return this;
	}

	public String getPhone(){
		return phone;
	}

	public CreateEmployee setMiddleName(String middleName){
		this.middleName = middleName;
		return this;
	}

	public String getMiddleName(){
		return middleName;
	}

	public CreateEmployee setId(int id){
		this.id = id;
		return this;
	}

	public int getId(){
		return id;
	}

	public CreateEmployee setIsActive(boolean isActive){
		this.isActive = isActive;
		return this;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public CreateEmployee setEmail(String email){
		this.email = email;
		return this;
	}

	public String getEmail(){
		return email;
	}

	public CreateEmployee setUrl(String url){
		this.url = url;
		return this;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return
			"CreateEmployee{" +
			"firstName = '" + firstName + '\'' +
			",lastName = '" + lastName + '\'' +
			",companyId = '" + companyId + '\'' +
			",birthdate = '" + birthdate + '\'' +
			",phone = '" + phone + '\'' +
			",middleName = '" + middleName + '\'' +
			",id = '" + id + '\'' +
			",isActive = '" + isActive + '\'' +
			",email = '" + email + '\'' +
			",url = '" + url + '\'' +
			"}";
		}
}
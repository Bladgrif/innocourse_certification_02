package com.onrender.x_clients_be.web.x_clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("companyId")
    private int companyId;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("lastChangedDateTime")
    private String lastChangedDateTime;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("id")
    private int id;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("email")
    private String email;

    @JsonProperty("createDateTime")
    private String createDateTime;

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    public int getCompanyId() {
        return companyId;
    }

    public Employee setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Employee setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
        return this;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public Employee setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public Employee setIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
        return this;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyId=" + companyId +
                ", birthdate='" + birthdate + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", lastChangedDateTime='" + lastChangedDateTime + '\'' +
                ", middleName='" + middleName + '\'' +
                ", id=" + id +
                ", isActive=" + isActive +
                ", email='" + email + '\'' +
                ", createDateTime='" + createDateTime + '\'' +
                '}';
    }
}
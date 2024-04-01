package com.onrender.x_clients_be.web.x_clients.helpers;

public class Company {

    public Integer addCompany(Company company) {
        int companyId = given()
                .contentType(ContentType.JSON)
                .body(company)
                .header("X-Client-Token", TOKEN)
                .when()
                .post(COMPANY.getPath())
                .then()
                .statusCode(201)
                .extract().path("id");
        return companyId;
    }
}

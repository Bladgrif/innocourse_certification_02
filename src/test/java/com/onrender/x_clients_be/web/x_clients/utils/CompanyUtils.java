package com.onrender.x_clients_be.web.x_clients.utils;

import com.onrender.x_clients_be.web.x_clients.models.Company;
import io.restassured.http.ContentType;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.COMPANY;
import static com.onrender.x_clients_be.web.x_clients.tests.EmployeeUtilsTests.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyUtils {

    public static Integer sendCompanyRequest(Company company) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null; //
        }
    }
}

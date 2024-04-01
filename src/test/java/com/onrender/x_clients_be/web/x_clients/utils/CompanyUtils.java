package com.onrender.x_clients_be.web.x_clients.utils;

import com.onrender.x_clients_be.web.x_clients.models.Company;
import io.restassured.http.ContentType;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.COMPANY;
import static com.onrender.x_clients_be.web.x_clients.tests.EmployeeTests.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyUtils {

    public static Integer postCompanyRequest(Company company) {
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
            System.out.println("Ошибка при вызове метода postCompanyRequest");
            e.printStackTrace();
            return null; //
        }
    }

    public static Company getCompanyById(String id) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/" + id)
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);
            return company;
        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода getCompanyById");
            e.printStackTrace();
            return null; //
//
        }
    }
}

package com.onrender.x_clients_be.web.x_clients.utils;

import com.onrender.x_clients_be.web.x_clients.generator.CompanyGenerator;
import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.models.CreateCompany;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.COMPANY;
import static com.onrender.x_clients_be.web.x_clients.tests.EmployeeTests.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyUtils {

    public static List<Company> getAllCompanies() {
        try {
            Response response = given()
                    .when()
                    .get(COMPANY.getPath())
                    .then()
                    .statusCode(200)
                    .extract().response();
            List<Company> companies = response.as(new TypeRef<List<Company>>() {
            });
            return companies;

        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода getAlCompanies");
            e.printStackTrace();
            return null;
        }
    }

    public static Integer addCompany() {
        try {
            int companyId = given()
                    .contentType(ContentType.JSON)
                    .body(CompanyGenerator.generateCompany())
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .post(COMPANY.getPath())
                    .then()
                    .statusCode(201)
                    .extract().path("id");
            return companyId;
        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода addCompany");
            e.printStackTrace();
            return null;
        }
    }

    public static Company getCompany(Integer id) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/" + Integer.toString(id))
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);
            return company;
        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода getCompanyById");
//            e.printStackTrace();
            return null;
//
        }
    }

    public static Company changeCompany(Integer id, CreateCompany createCompany) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .body(createCompany)
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .patch(COMPANY.getPath() + "/" + Integer.toString(id))
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);

            return company;

        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода changeCompany");
            e.printStackTrace();
            return null;
        }
    }

    public static Company deleteCompany(Integer id) {
        try {
            Company company = given()
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/delete/" + Integer.toString(id))
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);

            return company;

        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода deleteCompany");
            e.printStackTrace();
            return null;
        }
    }
}

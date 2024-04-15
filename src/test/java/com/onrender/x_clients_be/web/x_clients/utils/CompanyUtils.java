package com.onrender.x_clients_be.web.x_clients.utils;

import com.onrender.x_clients_be.web.x_clients.model.Company;
import com.onrender.x_clients_be.web.x_clients.model.CreateCompany;
import com.onrender.x_clients_be.web.x_clients.setup.BaseTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.COMPANY;
import static com.onrender.x_clients_be.web.x_clients.tests.EmployeeTests.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyUtils {
    static String xClient = "X-Client-Token";

    public static List<Company> getCompanies() {
        return getCompanies(null);
    }
    private  static List<Company> getCompanies(Boolean active) {
        try {
            String address = "";
            if (active != null) {
                address = "?active=" + active;
            }
            Response response = given()
                    .when()
                    .get(COMPANY.getPath() + address)
                    .then()
                    .statusCode(200)
                    .extract().response();
            List<Company> companies = response.as(new TypeRef<List<Company>>() {
            });
            return List.of();

        } catch (Exception e) {
            System.out.println("Error when calling getCompanies method" + e.getMessage());
            return null;
        }
    }

    public static Integer createCompany(CreateCompany createCompany) {
        try {
            int companyId = given()
                    .contentType(ContentType.JSON)
                    .body(createCompany)
                    .header(xClient, TOKEN)
                    .when()
                    .post(COMPANY.getPath())
                    .then()
                    .statusCode(201)
                    .extract().path("id");
            return companyId;
        } catch (Exception e) {
            System.out.println("Error when calling addCompany method" + e.getMessage());
            return null;
        }
    }

    public static Company getCompany(Integer id) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .header(xClient, TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/" + id)
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);
            return company;
        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода getCompanyById" + e.getMessage());
            return null;
        }
    }

    public static Company changeCompany(Integer id, CreateCompany createCompany) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .body(createCompany)
                    .header(xClient, TOKEN)
                    .when()
                    .patch(COMPANY.getPath() + "/" + Integer.toString(id))
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);

            return company;

        } catch (Exception e) {
            System.out.println("Error when calling the changeCompany method");
            e.printStackTrace();
            return null;
        }
    }

    public static Company deleteCompany(Integer id) {
        try {
            Company company = given()
                    .header(xClient, TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/delete/" + id)
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);

            return company;

        } catch (Exception e) {
            System.out.println("Error when calling deleteCompany method");
            e.printStackTrace();
            return null;
        }
    }

    public static Company updateCompanyStatus(Integer id, Boolean isActive) {
        try {
            if (isActive == null) {
                isActive = true;
            }
            String active = "{\n" +
                    "  \"isActive\": " + isActive + "\n" +
                    "}";

            Company company = given()
                    .header(xClient, TOKEN)
                    .contentType(ContentType.JSON)
                    .body(active)
                    .when()
                    .patch(COMPANY.getPath() + "/status/" + Integer.toString(id))
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);

            return company;

        } catch (Exception e) {
            System.out.println("Error when calling the activateCompany method");
            e.printStackTrace();
            return null;
        }
    }
}

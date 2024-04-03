package com.onrender.x_clients_be.web.x_clients.utils;

import com.onrender.x_clients_be.web.x_clients.models.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.models.Employee;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.EMPLOYEE;
import static com.onrender.x_clients_be.web.x_clients.setup.TestSetup.TOKEN;
import static io.restassured.RestAssured.given;

public class EmployeeUtils {

    public static Integer addEmployee(CreateEmployee employee) {
        int employeeId = given()
                .contentType(ContentType.JSON)
                .body(employee)
                .header("X-Client-Token", TOKEN)
                .when()
                .post(EMPLOYEE.getPath())
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .extract().path("id");
        return employeeId;
    }
}

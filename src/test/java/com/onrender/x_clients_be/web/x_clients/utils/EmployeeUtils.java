package com.onrender.x_clients_be.web.x_clients.utils;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.model.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.model.Employee;
import com.onrender.x_clients_be.web.x_clients.model.UpdateEmployee;
import io.restassured.http.ContentType;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.EMPLOYEE;
import static com.onrender.x_clients_be.web.x_clients.setup.BaseTest.TOKEN;
import static io.restassured.RestAssured.given;

public class EmployeeUtils {

    private static Faker faker;

    public static Integer addEmployee(CreateEmployee employee, Integer companyId) {
        employee.setCompanyId(companyId);

        try {
            int employeeId = given()
                    .contentType(ContentType.JSON)
                    .body(employee)
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .post(EMPLOYEE.getPath())
                    .then()
                    .extract().path("id");
            return employeeId;
        } catch (Exception e) {
            System.out.println("Error when calling addEmployee method" + e.getMessage());
            return null;
        }
    }

    public static Employee getEmployee(Integer employeeId) {

        try {
            Employee employee = given()
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .get(EMPLOYEE.getPath() + "/" + employeeId)
                    .then()
                    .extract().body().as(Employee.class);
            return employee;
        } catch (Exception e) {
            System.out.println("Error when calling getEmployee method" + e.getMessage());
            return null;
        }
    }

    public static Integer updateEmployee(Integer id, UpdateEmployee employee) {

        try {

            int employeeId  = given()
                    .contentType(ContentType.JSON)
                    .body(employee)
                    .header("X-Client-Token", TOKEN)
                    .when()
                    .patch(EMPLOYEE.getPath()+ "/" + id)
                    .then()
                    .extract().path("id");
            return employeeId;
        } catch (Exception e) {
            System.out.println("Error when calling updateEmployee method" + e.getMessage());
            return null;
        }
    }

    public static List<Employee>  getEmployeeList(Integer companyId) {

        try {

            List<Employee> companyEmployees = given()
                    .when()
                    .get(EMPLOYEE.getPath() + "?company=" + companyId)
                    .then()
                    .extract().body().jsonPath().getList(".", Employee.class);
            return companyEmployees;
        } catch (Exception e) {
            System.out.println("Error when calling getEmployeeList method" + e.getMessage());
            return null;
        }
    }
}

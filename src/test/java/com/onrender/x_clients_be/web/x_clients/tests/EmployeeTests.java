package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.models.AuthRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static com.onrender.x_clients_be.web.x_clients.helpers.Endpoints.AUTH_LOGIN;
import static io.restassured.RestAssured.given;

public class EmployeeTests {
    public static String TOKEN;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://x-clients-be.onrender.com/";

        AuthRequest authRequest = new AuthRequest()
                .setUsername("bloom")
                .setPassword("fire-fairy");

        TOKEN = given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post(AUTH_LOGIN.getPath())
                .then()
                .statusCode(201)
                .extract().path("userToken");
    }
}

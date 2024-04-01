package com.onrender.x_clients_be.web.x_clients.setup;

import com.onrender.x_clients_be.web.x_clients.models.AuthRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.AUTH_LOGIN;
import static io.restassured.RestAssured.given;

public class TestSetup {

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
//    eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiYWRtaW4iLCJpYXQiOjE3MTIwMDQ3NjYsImV4cCI6MTcxMjAwNTY2Nn0.5lledjBf7zy2THt7hygVLQCQ35N9_ZwSEi0SypCTrHg
}

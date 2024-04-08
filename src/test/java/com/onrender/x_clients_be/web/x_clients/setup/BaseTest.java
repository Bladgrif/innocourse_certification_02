package com.onrender.x_clients_be.web.x_clients.setup;

import com.onrender.x_clients_be.web.x_clients.config.ConfigJDBC;
import com.onrender.x_clients_be.web.x_clients.model.AuthRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.*;

import static com.onrender.x_clients_be.web.x_clients.config.Endpoints.AUTH_LOGIN;
import static io.restassured.RestAssured.given;

public class BaseTest {

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

package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.setup.TestSetup;
import com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTests extends TestSetup {
    String token = TOKEN;


    @Test
    void name() {
        Company company = CompanyUtils.getCompanyById("3234");
        System.out.println(company);

    }
}

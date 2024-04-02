package com.onrender.x_clients_be.web.x_clients.tests;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.generator.CompanyGenerator;
import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.models.CompanyToAdd;
import com.onrender.x_clients_be.web.x_clients.setup.TestSetup;
import com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class EmployeeTests extends TestSetup {
    String token = TOKEN;
    static Faker faker = new Faker();


    @Test
    void name() {
        System.out.println("добавить новую компанию");
        int id = CompanyUtils.addCompany();
        System.out.println("Добавили новую компанию: " + " id = " +id);
        System.out.println();

        Company company = CompanyUtils.getCompany(id);
        System.out.println("получить конкретную компанию");
        System.out.println(company);
        System.out.println();

        System.out.println("получим список всех компаний");
        List<Company> companies = CompanyUtils.getAllCompanies();
        System.out.println("Размер списка: " + companies.size());
        System.out.println();


        System.out.println("изменить компанию");
        System.out.println("старые названия: " + company.getName() + " " + company.getDescription());
        CompanyToAdd companyToAdd = CompanyGenerator.generateCompany();
        System.out.println("новые названия: " + companyToAdd.getName() + " " + companyToAdd.getDescription());
        Company company1 = CompanyUtils.changeCompany(id, companyToAdd);
        System.out.println("новые названия после изменения: " + company1.getName() + " " + company1.getDescription());


    }

//    @Test
//    void name2() {
//        CompanyToAdd companyToAdd = CompanyGenerator.generateCompany();
//        System.out.println(companyToAdd);
//
//    }
}
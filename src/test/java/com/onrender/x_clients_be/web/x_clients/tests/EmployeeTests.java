package com.onrender.x_clients_be.web.x_clients.tests;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.generator.CompanyGenerator;
import com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator;
import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.models.CreateCompany;
import com.onrender.x_clients_be.web.x_clients.setup.TestSetup;
import com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils;

import com.onrender.x_clients_be.web.x_clients.utils.EmployeeUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator.createEmployee;
import static com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils.*;
import static com.onrender.x_clients_be.web.x_clients.utils.EmployeeUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.given;

public class EmployeeTests extends TestSetup {
    String token = TOKEN;
    static Faker faker = new Faker();
    EmployeeUtils employeeUtils = new EmployeeUtils();

    @Test
    void companyTest() {
        System.out.println("добавить новую компанию");
        int id = createCompany();
        System.out.println("Добавили новую компанию: " + " id = " +id);
        System.out.println();

        Company company = getCompany(id);
        System.out.println("получить конкретную компанию");
        System.out.println(company);
        System.out.println();

        System.out.println("проверим статус компании");
        System.out.println(company.isIsActive());
        System.out.println();

        System.out.println("сделать компанию неактивной");
        System.out.println(updateCompanyStatus(id,false).isIsActive());
        System.out.println();

        System.out.println("сделать компанию активной");
        System.out.println(updateCompanyStatus(id,true).isIsActive());
        System.out.println();

        System.out.println("получим список всех компаний");
        List<Company> companies = getCompanies();
        System.out.println("Размер списка: " + companies.size());
        System.out.println();


        System.out.println("изменить компанию");
        System.out.println("старые названия: " + company.getName() + " " + company.getDescription());
        CreateCompany companyToAdd = CompanyGenerator.generateCompany();
        System.out.println("новые названия: " + companyToAdd.getName() + " " + companyToAdd.getDescription());
        Company company1 = changeCompany(id, companyToAdd);
        System.out.println("новые названия после изменения: " + company1.getName() + " " + company1.getDescription());
        System.out.println();

        System.out.println("удалить компанию");
        Company company2 = deleteCompany(id);
        System.out.println("удалили компанию: " + company2.getName() + " " + company2.getDescription());
        Company company3 = getCompany(id);
        assertNull(company3);
        System.out.println("компание удалена");

    }

    @Test
    void employeeTest() {
        System.out.println("Создать нового сотрудника");
        int id = addEmployee(createEmployee(),createCompany());
        System.out.println();

        System.out.println("Получить сотрудника");
        System.out.println(getEmployee(id));
        System.out.println();


        System.out.println("Изменить сотрудника");
        System.out.println(updateEmployee(id, EmployeeGenerator.updateEmployee()));
        System.out.println(getEmployee(id));
        System.out.println();

        System.out.println("Получить список сотрудников");
        System.out.println(getEmployeeList(3527));


    }
}

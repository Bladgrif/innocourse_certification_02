package com.onrender.x_clients_be.web.x_clients.generator;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.models.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.models.Employee;

import java.util.Locale;
import java.util.Random;

public class EmployeeGenerator {
    static Faker faker = new Faker(new Locale("ru"));
    static Random random = new Random();

    public static CreateEmployee createEmployee() {

        CreateEmployee employee = new CreateEmployee()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setCompanyId(3458)
                .setBirthdate("2024-03-17")
                .setPhone(String.valueOf(faker.number().digits(10)))
                .setMiddleName(faker.name().lastName())
                .setId(faker.number().randomDigit())
                .setIsActive(random.nextBoolean())
                .setEmail(faker.internet().emailAddress())
                .setUrl(faker.internet().url());
        return employee;
    }
}


package com.onrender.x_clients_be.web.x_clients.generator;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.model.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.model.UpdateEmployee;

import java.util.Locale;
import java.util.Random;

public class  EmployeeGenerator {
    static Faker faker = new Faker(new Locale("en"));
    static Random random = new Random();


    public static CreateEmployee createEmployee() {

        CreateEmployee employee = new CreateEmployee()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setPhone(String.valueOf(faker.number().digits(10)))
                .setMiddleName(faker.name().lastName())
                .setIsActive(random.nextBoolean())
                .setEmail(faker.internet().emailAddress())
                .setUrl(faker.internet().url());
        return employee;
    }

    public static String getBirthdate() {
        return faker.number().digits(4) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
    }

    public static UpdateEmployee updateEmployee() {

        UpdateEmployee employee = new UpdateEmployee()
                .setLastName(faker.name().lastName())
                .setPhone(String.valueOf(faker.number().digits(10)))
                .setIsActive(random.nextBoolean())
                .setEmail(faker.internet().emailAddress())
                .setUrl(faker.internet().url());
        return employee;
    }


}


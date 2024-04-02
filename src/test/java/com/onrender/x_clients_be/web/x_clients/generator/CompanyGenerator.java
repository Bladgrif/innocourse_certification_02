package com.onrender.x_clients_be.web.x_clients.generator;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.models.CreateCompany;

public class CompanyGenerator {
    static Faker faker = new Faker();

    public static CreateCompany generateCompany() {
        CreateCompany company = new CreateCompany()
                .setName((faker.company().industry()))
                .setDescription(faker.company().industry());
        return company;
    }
}

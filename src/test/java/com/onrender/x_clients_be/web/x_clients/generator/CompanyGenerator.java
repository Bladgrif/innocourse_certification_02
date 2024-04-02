package com.onrender.x_clients_be.web.x_clients.generator;

import com.github.javafaker.Faker;
import com.onrender.x_clients_be.web.x_clients.models.CompanyToAdd;

public class CompanyGenerator {
    static Faker faker = new Faker();

    public static CompanyToAdd generateCompany() {
        CompanyToAdd company = new CompanyToAdd()
                .setName((faker.company().industry()))
                .setDescription(faker.company().industry());
        return company;
    }
}

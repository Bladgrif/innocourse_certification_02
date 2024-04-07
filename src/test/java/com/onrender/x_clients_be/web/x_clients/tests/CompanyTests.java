package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.models.CreateCompany;
import com.onrender.x_clients_be.web.x_clients.setup.BaseTest;
import com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.generator.CompanyGenerator.generateCompany;
import static com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils.createCompany;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CompanyTests extends BaseTest {

    @Test
    void testGetCompanies() {
        List<Company> companies = CompanyUtils.getCompanies();
        assertThat(companies, not(empty()));
    }

    @Test
    void testGetCompanyById() {
        Integer companyId = createCompany();
        Company company = CompanyUtils.getCompany(companyId);
        assertThat(company, notNullValue());
    }

    @Test
    void testChangeCompany() {
        Integer companyId = createCompany();
        CreateCompany createdCompany = generateCompany();
        Company updatedCompany = CompanyUtils.changeCompany(companyId, createdCompany);
        assertThat(updatedCompany.getName(), equalTo(createdCompany.getName()));
    }


    @Test
    void testUpdateCompanyStatus() {
        Integer companyId = createCompany();
        Company updatedCompany = CompanyUtils.updateCompanyStatus(companyId, false);
        assertThat(updatedCompany.isIsActive(), is(false));
        updatedCompany = CompanyUtils.updateCompanyStatus(companyId, true);
        assertThat(updatedCompany.isIsActive(), is(true));
    }

}

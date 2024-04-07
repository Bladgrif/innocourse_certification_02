package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator;
import com.onrender.x_clients_be.web.x_clients.models.Company;
import com.onrender.x_clients_be.web.x_clients.models.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.models.Employee;
import com.onrender.x_clients_be.web.x_clients.models.UpdateEmployee;
import com.onrender.x_clients_be.web.x_clients.setup.BaseTest;
import com.onrender.x_clients_be.web.x_clients.utils.EmployeeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator.createEmployee;
import static com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils.createCompany;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests extends BaseTest {

    @Test
    void testAddEmployee() {
        CreateEmployee employee = createEmployee();
        Integer employeeId = EmployeeUtils.addEmployee(employee, createCompany());
        assertThat(employeeId, notNullValue());
    }

    @Test
    void testGetEmployee() {
        Integer employeeId = EmployeeUtils.addEmployee(createEmployee(), createCompany());
        Employee employeeInfo = EmployeeUtils.getEmployee(employeeId);
        assertThat(employeeInfo, notNullValue());
    }

    @Test
    void testUpdateEmployee() {
        CreateEmployee employee = createEmployee();
        Integer employeeId = EmployeeUtils.addEmployee(employee, createCompany());
        UpdateEmployee updateEmployee = EmployeeGenerator.updateEmployee();
        Integer updatedEmployeeId = EmployeeUtils.updateEmployee(employeeId, updateEmployee);
        assertNotEquals(employee.getEmail(),EmployeeUtils.getEmployee(updatedEmployeeId).getEmail());
    }

    @Test
    void testGetEmployeeList() {
        Integer companyId = createCompany();
        Integer employeeIdFirst = EmployeeUtils.addEmployee(createEmployee(), companyId);
        Integer employeeIdSecond = EmployeeUtils.addEmployee(createEmployee(), companyId);
        Integer employeeIdThird = EmployeeUtils.addEmployee(createEmployee(), companyId);
        List<Employee> employeeList = EmployeeUtils.getEmployeeList(companyId);
        assertThat(employeeList, not(empty()));

        assertThat(employeeList, containsInAnyOrder(
                hasProperty("id", equalTo(employeeIdFirst)),
                hasProperty("id", equalTo(employeeIdSecond)),
                hasProperty("id", equalTo(employeeIdThird))
        ));
    }

//    String token = TOKEN;
//    static Faker faker = new Faker();
//    EmployeeUtils employeeUtils = new EmployeeUtils();

//    @Test
//    void companyTest() {
//        System.out.println("добавить новую компанию");
//        int id = createCompany();
//        System.out.println("Добавили новую компанию: " + " id = " +id);
//        System.out.println();
//
//        Company company = getCompany(id);
//        System.out.println("получить конкретную компанию");
//        System.out.println(company);
//        System.out.println();
//
//        System.out.println("проверим статус компании");
//        System.out.println(company.isIsActive());
//        System.out.println();
//
//        System.out.println("сделать компанию неактивной");
//        System.out.println(updateCompanyStatus(id,false).isIsActive());
//        System.out.println();
//
//        System.out.println("сделать компанию активной");
//        System.out.println(updateCompanyStatus(id,true).isIsActive());
//        System.out.println();
//
//        System.out.println("получим список всех компаний");
//        List<Company> companies = getCompanies();
//        System.out.println("Размер списка: " + companies.size());
//        System.out.println();
//
//
//        System.out.println("изменить компанию");
//        System.out.println("старые названия: " + company.getName() + " " + company.getDescription());
//        CreateCompany companyToAdd = CompanyGenerator.generateCompany();
//        System.out.println("новые названия: " + companyToAdd.getName() + " " + companyToAdd.getDescription());
//        Company company1 = changeCompany(id, companyToAdd);
//        System.out.println("новые названия после изменения: " + company1.getName() + " " + company1.getDescription());
//        System.out.println();
//
//        System.out.println("удалить компанию");
//        Company company2 = deleteCompany(id);
//        System.out.println("удалили компанию: " + company2.getName() + " " + company2.getDescription());
//        Company company3 = getCompany(id);
//        assertNull(company3);
//        System.out.println("компание удалена");
//
//    }
//
//    @Test
//    void employeeTest() {
//        System.out.println("Создать нового сотрудника");
//        int id = addEmployee(createEmployee(),createCompany());
//        System.out.println();
//
//        System.out.println("Получить сотрудника");
//        System.out.println(getEmployee(id));
//        System.out.println();
//
//
//        System.out.println("Изменить сотрудника");
//        System.out.println(updateEmployee(id, EmployeeGenerator.updateEmployee()));
//        System.out.println(getEmployee(id));
//        System.out.println();
//
//        System.out.println("Получить список сотрудников");
//        System.out.println(getEmployeeList(3527));
//
//
//    }
}

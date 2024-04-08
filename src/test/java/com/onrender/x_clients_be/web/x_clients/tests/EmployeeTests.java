package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.db.jdbc.model.EmployeeAndCompanyJDBC;
import com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator;
import com.onrender.x_clients_be.web.x_clients.model.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.model.Employee;
import com.onrender.x_clients_be.web.x_clients.model.UpdateEmployee;
import com.onrender.x_clients_be.web.x_clients.setup.BaseTest;
import com.onrender.x_clients_be.web.x_clients.utils.EmployeeUtils;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator.createEmployee;
import static com.onrender.x_clients_be.web.x_clients.utils.CompanyUtils.createCompany;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests extends BaseTest {

    EmployeeAndCompanyJDBC employeeAndCompanyJDBC = new EmployeeAndCompanyJDBC();

    @Test
    void testAddEmployee() {
        CreateEmployee employee = createEmployee();
        Integer employeeId = EmployeeUtils.addEmployee(employee, createCompany());
        assertNotNull(employeeId, "Failed to add employee");
        assertEquals(employeeAndCompanyJDBC.isEmployeeExists(employeeId),1, "Failed to add employee");

    }

//    @Test
//    void testAddNotCorrectEmployee() {
//        CreateEmployee employee = new CreateEmployee();
//        Integer employeeId = EmployeeUtils.addEmployee(employee, createCompany());
//        assertNull(employeeId, "Failed to add employee");
//    }

    @Test
    void testGetEmployee() {
        Integer employeeId = EmployeeUtils.addEmployee(createEmployee(), createCompany());
        Employee employeeInfo = EmployeeUtils.getEmployee(employeeId);
        assertNotNull(employeeInfo, "Failed to get employee");
    }

    @Test
    void testUpdateEmployee() {
        CreateEmployee employee = createEmployee();
        Integer employeeId = EmployeeUtils.addEmployee(employee, createCompany());
        UpdateEmployee updateEmployee = EmployeeGenerator.updateEmployee();
        Integer updatedEmployeeId = EmployeeUtils.updateEmployee(employeeId, updateEmployee);
        assertNotEquals(employee.getEmail(), EmployeeUtils.getEmployee(updatedEmployeeId).getEmail(),
                "Failed to update employee");
    }

    @Test
    void testGetEmployeeList() {
        Integer companyId = createCompany();
        Integer employeeIdFirst = EmployeeUtils.addEmployee(createEmployee(), companyId);
        Integer employeeIdSecond = EmployeeUtils.addEmployee(createEmployee(), companyId);
        Integer employeeIdThird = EmployeeUtils.addEmployee(createEmployee(), companyId);
        List<Employee> employeeList = EmployeeUtils.getEmployeeList(companyId);
        assertThat(employeeList, not(empty()));
        assertNotNull(employeeList,  "Failed to retrieve employee list");

        assertThat(employeeList, containsInAnyOrder(
                hasProperty("id", equalTo(employeeIdFirst)),
                hasProperty("id", equalTo(employeeIdSecond)),
                hasProperty("id", equalTo(employeeIdThird))
        ));

    }
}

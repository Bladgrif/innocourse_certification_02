package com.onrender.x_clients_be.web.x_clients.tests;

import com.onrender.x_clients_be.web.x_clients.db.jdbc.model.EmployeeAndCompanyJDBC;
import com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator;
import com.onrender.x_clients_be.web.x_clients.model.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.model.Employee;
import com.onrender.x_clients_be.web.x_clients.model.UpdateEmployee;
import com.onrender.x_clients_be.web.x_clients.setup.BaseTest;
import com.onrender.x_clients_be.web.x_clients.utils.EmployeeUtils;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.onrender.x_clients_be.web.x_clients.generator.CompanyGenerator.generateCompany;
import static com.onrender.x_clients_be.web.x_clients.generator.EmployeeGenerator.createEmployee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests extends BaseTest {

    private CreateEmployee employee;
    private CreateEmployee employee_2;
    private CreateEmployee employee_3;
    private Integer employeeId;
    private Integer employee_2_Id;
    private Integer employee_3_Id;
    private Integer companyId;

    EmployeeAndCompanyJDBC employeeAndCompanyJDBC = new EmployeeAndCompanyJDBC();

    @BeforeEach
    void setUp() {
        employee = createEmployee();
        employee_2 = createEmployee();
        employee_3 = createEmployee();
        companyId = employeeAndCompanyJDBC.insertCompany(generateCompany());
    }

    @AfterEach
    void tearDown() {
        if (employeeId != null) {
            employeeAndCompanyJDBC.deleteEmployeeById(employeeId);
        }
        if (companyId != null) {
            employeeAndCompanyJDBC.deleteCompanyById(companyId);
        }
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Creating an employee")
    void testAddEmployee() {
        employee.setCompanyId(companyId);
        employeeId = EmployeeUtils.addEmployee(employee, companyId);

        assertNotNull(employeeId, "Failed to add employee");
        assertEquals(employeeAndCompanyJDBC.isEmployeeExists(employeeId), 1, "Failed to add employee");
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Creating an employee with incorrect data")
    void testAddIncorrectEmployee() {
        employee.setCompanyId(companyId);
        employee.setFirstName("");
        employeeId = EmployeeUtils.addEmployee(employee, companyId);

        assertNull(employeeId, "Employee with incorrect data should not be added");
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("read")
    @DisplayName("Getting an employee")
    void testGetEmployee() {
        employeeId = employeeAndCompanyJDBC.insertEmployee(employee, companyId);
        Employee employeeInfo = EmployeeUtils.getEmployee(employeeId);

        assertNotNull(employeeInfo, "Failed to get employee");
        assertEquals(employeeInfo.getId(), employeeAndCompanyJDBC.getEmployeeById(employeeId).getId(), "Failed to get employee");
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("read")
    @DisplayName("Getting an deleted employee")
    void testGetIncorrectEmployee() {
        employeeId = employeeAndCompanyJDBC.insertEmployee(employee, companyId);
        Employee employeeInfo = EmployeeUtils.getEmployee(employeeId);
        assertNotNull(employeeInfo, "Failed to get employee");

        employeeAndCompanyJDBC.deleteEmployeeById(employeeId);

        employeeInfo = EmployeeUtils.getEmployee(employeeId);
        assertNull(employeeInfo,"The remote employee should not be found");
        assertNull(employeeAndCompanyJDBC.getEmployeeById(employeeId));
    }

    @Test
    @Tag("all")
    @Tag("put")
    @Tag("update")
    @DisplayName("Employee update")
    void testUpdateEmployee() {
        UpdateEmployee updateEmployee = EmployeeGenerator.updateEmployee();

        employeeId = employeeAndCompanyJDBC.insertEmployee(employee, companyId);

        Integer updatedEmployeeId = EmployeeUtils.updateEmployee(employeeId, updateEmployee);
        assertNotEquals(employee.getEmail(), EmployeeUtils.getEmployee(updatedEmployeeId).getEmail(), "Failed to update employee");
        assertEquals(employeeAndCompanyJDBC.getEmployeeById(employeeId).getEmail(), EmployeeUtils.getEmployee(updatedEmployeeId).getEmail(), "Failed to update employee");
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("read")
    @DisplayName("Getting a list of employees")
    void testGetEmployeeList() {
        employeeId = employeeAndCompanyJDBC.insertEmployee(employee, companyId);
        employee_2_Id = employeeAndCompanyJDBC.insertEmployee(employee_2, companyId);
        employee_3_Id = employeeAndCompanyJDBC.insertEmployee(employee_3, companyId);

        List<Employee> employeeList = EmployeeUtils.getEmployeeList(companyId);
        assertEquals(employeeList.size(), 3, "Failed to get employee list");

        assertThat(employeeList, contains(
                hasProperty("id", equalTo(employeeId)),
                hasProperty("id", equalTo(employee_2_Id)),
                hasProperty("id", equalTo(employee_3_Id))
        ));

        List<Integer> employeeIds = employeeAndCompanyJDBC.getEmployeeIdsByCompanyId(companyId);
        assertThat(employeeIds, contains(employeeId, employee_2_Id, employee_3_Id));

        employeeAndCompanyJDBC.deleteEmployeeById(employee_2_Id);
        employeeAndCompanyJDBC.deleteEmployeeById(employee_3_Id);
    }
}

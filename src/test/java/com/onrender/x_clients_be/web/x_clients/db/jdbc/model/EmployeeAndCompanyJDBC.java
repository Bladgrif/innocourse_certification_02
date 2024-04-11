package com.onrender.x_clients_be.web.x_clients.db.jdbc.model;

import com.onrender.x_clients_be.web.x_clients.db.jdbc.DatabaseManager;
import com.onrender.x_clients_be.web.x_clients.model.CreateCompany;
import com.onrender.x_clients_be.web.x_clients.model.CreateEmployee;
import com.onrender.x_clients_be.web.x_clients.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeAndCompanyJDBC {

    private final String sqlSelectGetById = "SELECT COUNT(*) FROM employee WHERE id = ?";
    private final String sqlSelectEmployeeById = "SELECT * FROM employee WHERE id = ?";
    private final String sqlSelectEmployeesByCompanyId = "SELECT * FROM employee WHERE company_id = ?";
    private final String sqlDeleteEmpById = "DELETE FROM employee WHERE id= ?";
    private final String sqlDeleteCompById = "DELETE FROM company WHERE id = ?";
    private final String sqlInsertCompany = "INSERT INTO company(name,description) values (?,?)";
    private final String sqlInsertEmployee = "INSERT INTO employee (first_name, last_name, middle_name, email, phone, company_id) VALUES (?,?,?,?,?,?)";


    private final DatabaseManager databaseManager;

    public EmployeeAndCompanyJDBC() {
        this.databaseManager = new DatabaseManager();
    }

    public Integer isEmployeeExists(int employeeId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSelectGetById)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            System.out.println("Error executing isEmployeeExists request: " + e.getMessage());
        }

        return null;
    }

    public Employee getEmployeeById(int employeeId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSelectEmployeeById)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Employee employee = new Employee()
                        .setFirstName(resultSet.getString("first_name"))
                        .setLastName(resultSet.getString("last_name"))
                        .setCompanyId(resultSet.getInt("company_id"))
                        .setBirthdate(resultSet.getString("birthdate"))
                        .setAvatarUrl(resultSet.getString("avatar_url"))
                        .setPhone(resultSet.getString("phone"))
                        .setLastChangedDateTime(resultSet.getString("change_timestamp"))
                        .setMiddleName(resultSet.getString("middle_name"))
                        .setId(resultSet.getInt("id"))
                        .setIsActive(resultSet.getBoolean("is_active"))
                        .setEmail(resultSet.getString("email"))
                        .setCreateDateTime(resultSet.getString("create_timestamp"));
                return employee;
            }
        } catch (SQLException e) {
            System.out.println("Error executing getEmployeeById request: " + e.getMessage());
        }

        return null;
    }

    public List<Integer> getEmployeeIdsByCompanyId(int companyId) {
        List<Integer> employeeIds = new ArrayList<>();

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSelectEmployeesByCompanyId)) {

            statement.setInt(1, companyId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                employeeIds.add(employeeId);
            }
        } catch (SQLException e) {
            System.out.println("Error executing getEmployeeIdsByCompanyId request: " + e.getMessage());
        }

        return employeeIds;
    }

    public void deleteEmployeeById(int employeeId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlDeleteEmpById)) {

            statement.setInt(1, employeeId);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing deleteEmployeeById request: " + e.getMessage());
        }
    }

    public void deleteCompanyById(int companyId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlDeleteCompById)) {

            statement.setInt(1, companyId);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing deleteCompanyById request: " + e.getMessage());
        }
    }

    public Integer insertCompany(CreateCompany company) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlInsertCompany, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, company.getName());
            statement.setString(2, company.getDescription());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            return keys.getInt(7);
        } catch (SQLException e) {
            System.out.println("Error executing insertCompany request: " + e.getMessage());
            return null;
        }
    }

    public Integer insertEmployee(CreateEmployee employee, int companyId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlInsertEmployee, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getMiddleName());
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getPhone());
            statement.setInt(6, companyId);

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error executing insertEmployee request: " + e.getMessage());
            return null;
        }
    }
}
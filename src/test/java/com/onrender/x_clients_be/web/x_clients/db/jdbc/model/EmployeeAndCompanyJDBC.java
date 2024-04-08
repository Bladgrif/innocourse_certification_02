package com.onrender.x_clients_be.web.x_clients.db.jdbc.model;

import com.onrender.x_clients_be.web.x_clients.db.jdbc.DatabaseManager;
import com.onrender.x_clients_be.web.x_clients.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeAndCompanyJDBC {

    private final String sqlSelectGetById = "SELECT COUNT(*) FROM employee WHERE id = ?";
    private final String sqlSelectEmployeeById = "SELECT * FROM employee WHERE id = ?";
    private final String sqlDeleteEmpById = "DELETE FROM employee WHERE id = ?";
    private final String sqlDeleteCompById = "DELETE FROM company WHERE id = ?";
    private final String sqlInsertCompany = "INSERT INTO company(name) VALUES (?)";
    private final String sqlInsertEmployee = "INSERT INTO employee (first_name, last_name, middle_name, email, phone, birthdate, company_id) VALUES (?,?,?,?,?,?,?)";

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
}
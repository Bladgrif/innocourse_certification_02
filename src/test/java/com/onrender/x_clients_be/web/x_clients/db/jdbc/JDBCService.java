package com.onrender.x_clients_be.web.x_clients.db.jdbc;

import com.onrender.x_clients_be.web.x_clients.config.Config;

import java.sql.*;

public class JDBCService {
    public static void main(String[] args) {
        String url = Config.getDbUrl();
        String user = Config.getDbUser();
        String password = Config.getDbPassword();
        String sql = "SELECT * FROM company";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении запроса");
            e.printStackTrace();
        }
    }

}

package ru.inno.course;

import java.sql.*;

public class Iterator {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
        String user = "x_clients_user";
        String password = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";
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

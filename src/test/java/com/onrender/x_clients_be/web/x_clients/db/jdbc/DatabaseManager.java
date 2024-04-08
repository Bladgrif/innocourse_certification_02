package com.onrender.x_clients_be.web.x_clients.db.jdbc;

import com.onrender.x_clients_be.web.x_clients.config.ConfigJDBC;

import java.sql.*;

public class DatabaseManager  {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseManager () {
        this.url = ConfigJDBC.getDbUrl();
        this.user = ConfigJDBC.getDbUser();
        this.password = ConfigJDBC.getDbPassword();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
package com.onrender.x_clients_be.web.x_clients.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigJDBC {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUser() {
        return properties.getProperty("db.user");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}


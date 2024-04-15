package com.onrender.x_clients_be.web.x_clients.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigApi {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getApiUser() {
        return properties.getProperty("api.username");
    }

    public static String getApiPassword() {
        return properties.getProperty("api.password");
    }
}


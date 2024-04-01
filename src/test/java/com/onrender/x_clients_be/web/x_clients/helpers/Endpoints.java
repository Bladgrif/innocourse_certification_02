package com.onrender.x_clients_be.web.x_clients.helpers;

public enum Endpoints {
    AUTH_LOGIN("auth/login"),
    COMPANY("company"),
    EMPLOYEE("employee");

    private final String path;

    private Endpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}

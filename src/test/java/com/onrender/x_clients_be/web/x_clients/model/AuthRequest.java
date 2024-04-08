package com.onrender.x_clients_be.web.x_clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {

    @JsonProperty("password")
    private String password;

    @JsonProperty("username")
    private String username;

    public AuthRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUsername() {
        return username;
    }
}
package com.example.restapi.model;

public class UserPrincipal {

    private Integer id;
    private String username;
    private boolean isAdmin;

    public UserPrincipal(Integer userId, String username, boolean isAdmin) {
        this.id = userId;
        this.username = username;
        this.isAdmin = isAdmin;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

package com.example.restapi.model;

import javax.persistence.*;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;

    private String email;

    private String password;

    private Integer admin = 0;

    public User() {}

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
    public String getEmail() {
        return password;
    }
    public void setEmail(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAdmin() {
        return admin;
    }
    public void setAdmin(Integer admin) {
        this.admin = admin;
    }
    public boolean isAdmin(Integer admin) {
        return admin == 1;
    }

}

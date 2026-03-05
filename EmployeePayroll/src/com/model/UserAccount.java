package com.model;

import com.util.PasswordUtil;

public class UserAccount {

    private String username;
    private String passwordHash;
    private String role;

    public UserAccount(String username, String password, String role) {

        this.username = username;
        this.passwordHash = PasswordUtil.hashPassword(password);
        this.role = role.toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }
}
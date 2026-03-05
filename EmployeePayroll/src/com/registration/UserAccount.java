package com.registration;

public class UserAccount {

    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

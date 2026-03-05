package com.model;

import com.util.PasswordUtil;

public class Manager extends User {

    public Manager(String username, String passwordHash) {
        super(username, passwordHash, "MANAGER");
    }

    @Override
    public boolean authenticate(String username, String password) {

        if(this.username.equals(username) &&
           PasswordUtil.verifyPassword(password, passwordHash))
            return true;

        return false;
    }
}

package com.model;

import com.util.PasswordUtil;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String passwordHash) {
        super(username, passwordHash, "EMPLOYEE");
    }

    @Override
    public boolean authenticate(String username, String password) {

        if(this.username.equals(username) &&
           PasswordUtil.verifyPassword(password, passwordHash))
            return true;

        return false;
    }
}

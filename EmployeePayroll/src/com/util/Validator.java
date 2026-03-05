package com.util;

import java.util.regex.*;

public class Validator {

    public static boolean validateEmpId(String empId) {
        return empId.matches("EMP-\\d{4}");
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("[9876]\\d{9}");
    }
}

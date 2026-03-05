package com.validation;


import com.exceptions.*;

public class ValidationUtil {

    public static void validateEmail(String email) throws EmailValidationException {

        String pattern = "^[A-Za-z0-9+_.-]+@(.+)$";

        if(!email.matches(pattern)) {
            throw new EmailValidationException("Invalid Email Format.");
        }
    }

    public static void validatePhone(String phone) throws PhoneValidationException {

        String pattern = "^[0-9]{10}$";

        if(!phone.matches(pattern)) {
            throw new PhoneValidationException("Phone number must be 10 digits.");
        }
    }

    public static void validatePassword(String password) throws PasswordValidationException {

        String pattern = "^(?=.*[A-Z])(?=.*[0-9]).{6,}$";

        if(!password.matches(pattern)) {
            throw new PasswordValidationException(
                    "Password must contain 1 uppercase letter, 1 number and minimum 6 characters."
            );
        }
    }

    public static void validateEmployeeId(String empId) throws EmployeeIdValidationException {

        String pattern = "^EMP-[0-9]{4}$";

        if(!empId.matches(pattern)) {
            throw new EmployeeIdValidationException(
                    "Employee ID must be in format EMP-0001"
            );
        }
    }
}
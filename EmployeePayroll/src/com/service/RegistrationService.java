package com.service;

import java.util.Scanner;

import com.model.Employee;
import com.model.UserAccount;
import com.util.FileService;
import com.util.Validator;

import com.validation.*;
import com.exceptions.*;

public class RegistrationService {

    public static Employee registerEmployee() {
    	

        Scanner sc = new Scanner(System.in);

        System.out.println("=== EMPLOYEE REGISTRATION ===");

        System.out.print("Enter Employee ID (EMP-XXXX): ");
        String empId = sc.nextLine();

//        if(!Validator.validateEmpId(empId)){
//            System.out.println("Invalid Employee ID format");
//            return null;
//        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

//        if(!Validator.validateEmail(email)){
//            System.out.println("Invalid Email");
//            return null;
//        }

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

//        if(!Validator.validatePhone(phone)){
//            System.out.println("Invalid Phone");
//            return null;
//        }

        System.out.print("Create Username: ");
        String username = sc.nextLine();

        System.out.print("Create Password: ");
        String password = sc.nextLine();
        
        System.out.print("Enter type: ");
        String type = sc.nextLine();
        
        
        try {

            email = InputSanitizer.sanitize(email);
            phone = InputSanitizer.sanitize(phone);
            password = InputSanitizer.sanitize(password);
            empId = InputSanitizer.sanitize(empId);
            
            ValidationUtil.validateEmployeeId(empId);
            ValidationUtil.validateEmail(email);
            ValidationUtil.validatePhone(phone);
            ValidationUtil.validatePassword(password);
            

            System.out.println("All inputs are valid.");

        }
        catch(ValidationException e) {

            System.out.println("Validation Error: " + e.getMessage());
            return null;

        }
        
        UserAccount account = new UserAccount(username, password, type);

        Employee emp = new Employee(empId, name, email, phone, account);

        FileService.saveEmployee(emp);

        return emp;
    }
}

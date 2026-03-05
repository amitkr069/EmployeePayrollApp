package com.service;

import java.util.Scanner;

import com.model.Employee;
import com.model.UserAccount;
import com.util.PasswordUtil;

public class LoginService {


    public static void login(Employee emp) {

        Scanner sc = new Scanner(System.in);



        System.out.println("\n=== EMPLOYEE LOGIN ===");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        UserAccount acc = emp.getAccount();

        if(username.equals(acc.getUsername()) &&
           PasswordUtil.verifyPassword(password, acc.getPasswordHash())){

            System.out.println("\nLogin Successful!");
            System.out.println("Role: " + acc.getRole());

            SessionManager.startSession(username);

            showDashboard();

        }
        else{

            System.out.println("Invalid credentials!");

        }
    }

    private static void showDashboard(){

        System.out.println("\n======= DASHBOARD =======");
        System.out.println("Employee Dashboard");
        System.out.println("View Payslip | Update Profile");
    }
}
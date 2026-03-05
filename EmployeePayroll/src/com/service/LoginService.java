package com.service;

import java.util.Scanner;


import com.model.*;
import com.util.PasswordUtil;

import com.service.*;

import java.util.List;
import java.util.ArrayList;
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

            showDashboard(emp);

        }
        else{

            System.out.println("Invalid credentials!");

        }
    }

    private static void showDashboard(Employee emp){
    	Payslip payslip = null;
    	List<Payslip> payslipList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n======= DASHBOARD =======");
            System.out.println("1. Generate Payslip");
            System.out.println("2. Download Payslip");
            System.out.println("3. Show Dashboard");
            System.out.println("4. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    payslip = PayslipService.generatePayslip(emp);
                    payslipList.add(payslip);
                    break;
                
                case 2:
                    PayslipPrintDownload.execute(payslip);
                    break;
                case 3:
                	DashboardService dashboardService = new DashboardService();
                    dashboardService.showDashboard("EMPLOYEE", payslipList);
                    break;
                case 4:
                    SessionManager.endSession();
                    System.out.println("Logged out!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
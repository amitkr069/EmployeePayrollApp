package com.service;

import java.util.Scanner;
import com.model.*;
public class PayslipService {

    public static void generatePayslip(Employee emp) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== PAYSLIP GENERATION ===");

        System.out.print("Enter Month (e.g., January 2026): ");
        String month = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Enter HRA: ");
        double hra = sc.nextDouble();

        System.out.print("Enter DA: ");
        double da = sc.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();

        SalaryComponents salary = new SalaryComponents()
                .setBasic(basic)
                .setHra(hra)
                .setDa(da)
                .setAllowances(allowances);

        Payslip payslip = new Payslip(month, emp, salary);

        System.out.println(payslip);
    }
}
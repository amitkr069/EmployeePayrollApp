/**
 * @author Amit
 * @version 4.0
 * 
 * Use Case 4:
 * Payslip generate and download.
 */
package com.main;
import com.model.*;
import com.service.*;

import java.util.Scanner;
public class EmployeePayroll {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee user = null;
        Payslip generatedPayslip = null;

        while(true){

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    user = RegistrationService.registerEmployee();
                    break;

                case 2:
                    if(user == null)
                        System.out.println("Please register first!");
                    else
                        LoginService.login(user);
                    break;
                 
                
                case 3:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

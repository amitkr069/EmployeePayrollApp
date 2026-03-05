/**
 * @author Amit
 * @version 2.0
 * 
 * Use Case 2:
 * Implemented user login feature.
 */
package com.main;
import com.model.*;
import com.service.LoginService;
import com.service.RegistrationService;

import java.util.Scanner;
public class EmployeePayroll {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee user = null;

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

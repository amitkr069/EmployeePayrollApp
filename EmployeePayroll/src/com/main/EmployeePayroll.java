package com.main;
import com.registration.*;
public class EmployeePayroll {
	public static void main(String[] args) {

        Employee emp = RegistrationService.registerEmployee();

        if(emp != null){
            System.out.println("\nEmployee Registered Successfully:");
            System.out.println(emp);
        }

    }
}

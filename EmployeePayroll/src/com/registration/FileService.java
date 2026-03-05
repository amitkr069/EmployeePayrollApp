package com.registration;

import java.io.*;

public class FileService {

    public static void saveEmployee(Employee emp) {

        try {
            FileWriter fw = new FileWriter("employee_data.txt", true);
            fw.write(emp.toString());
            fw.write("\n----------------------\n");
            fw.close();

            System.out.println("\nData persisted in file: employee_data.txt");

        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }
}
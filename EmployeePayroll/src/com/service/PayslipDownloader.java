package com.service;


import com.model.Payslip;

import java.io.FileWriter;
import java.io.IOException;

public class PayslipDownloader {

    private long expiryTime;

    public PayslipDownloader() {
        expiryTime = System.currentTimeMillis() + 60000; // 1 minute expiry
    }

    public Payslip clonePayslip(Payslip original) {
        return original.clone();
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }

    public void saveAsText(Payslip payslip) {

        String filename = "Payslip_" + payslip.getEmployee().getEmpId()
                + "_" + System.currentTimeMillis() + ".txt";

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(payslip.toString());
            writer.close();

            System.out.println("Saved as text file: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void saveAsPDF(Payslip payslip) {

        String filename = "Payslip_" + payslip.getEmployee().getEmpId()
                + "_" + System.currentTimeMillis() + ".pdf";

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(payslip.toString());
            writer.close();

            System.out.println("Saved as PDF file: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

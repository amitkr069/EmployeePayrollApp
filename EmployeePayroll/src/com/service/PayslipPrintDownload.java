package com.service;



import com.model.Payslip;

public class PayslipPrintDownload {

    public static void execute(Payslip original) {

        System.out.println("\n=== PAYSLIP PRINT / DOWNLOAD ===");

        if(original == null){
            System.out.println("No payslip generated yet.");
            return;
        }

        System.out.println("\nOriginal Payslip:");
        System.out.println(original);

        PayslipDownloader downloader = new PayslipDownloader();

        // Clone
        Payslip cloned = downloader.clonePayslip(original);

        // Validate
        if(original.equals(cloned)){
            System.out.println("\nVerified: Download copy is equal to original.");
            System.out.println("Original hashcode : " + original.hashCode());
            System.out.println("Cloned  hashcode : " + cloned.hashCode());
        }

        // Expiry check
        if(!downloader.isExpired()){

            downloader.saveAsText(cloned);
            downloader.saveAsPDF(cloned);

            System.out.println("\nPayslip Download Successful.");

        } else {

            System.out.println("Download link expired.");

        }

        // Print
        System.out.println("\n--- Printed Payslip ---");
        System.out.println(cloned);

    }
}
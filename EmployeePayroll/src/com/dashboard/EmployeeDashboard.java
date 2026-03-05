package com.dashboard;



import com.model.Payslip;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeDashboard implements Dashboard {

    @Override
    public void displayDashboard(List<Payslip> payslips) {

        System.out.println("\n======= DASHBOARD =======");

        if(payslips == null || payslips.size() == 0){
            System.out.println("No payslips available.");
            return;
        }

        // Top 3 recent payslips
        List<Payslip> recent = payslips.stream()
                .sorted(Comparator.comparing(Payslip::getMonth).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nRecent Payslips:");

        for(Payslip p : recent){
            System.out.println(p);
        }

        // YTD earnings
        double total = payslips.stream()
                .mapToDouble(Payslip::getNetPay)
                .sum();

        System.out.println("\nYTD Earnings : " + total);

        System.out.println("\nDashboard Type : " + this.getClass().getSimpleName());
    }
}
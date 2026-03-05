package com.service;


import com.model.Payslip;
import com.dashboard.Dashboard;
import com.factory.DashboardFactory;

import java.util.List;

public class DashboardService {

    public void showDashboard(String role, List<Payslip> payslips){

        Dashboard dashboard = DashboardFactory.getDashboard(role);

        if(dashboard != null){
            dashboard.displayDashboard(payslips);
        }
        else{
            System.out.println("Dashboard not available.");
        }
    }
}
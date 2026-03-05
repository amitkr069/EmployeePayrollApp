package com.factory;

import com.dashboard.*;

public class DashboardFactory {

    public static Dashboard getDashboard(String role){

        if(role.equalsIgnoreCase("EMPLOYEE")){
            return new EmployeeDashboard();
        }

        return null;
    }
}
package com.model;

import java.util.*;
import java.util.stream.*;

public class SalaryComponents {

    private double basic;
    private double hra;
    private double da;
    private double allowances;

    public SalaryComponents setBasic(double basic) {
        this.basic = basic;
        return this;
    }

    public SalaryComponents setHra(double hra) {
        this.hra = hra;
        return this;
    }

    public SalaryComponents setDa(double da) {
        this.da = da;
        return this;
    }

    public SalaryComponents setAllowances(double allowances) {
        this.allowances = allowances;
        return this;
    }

    public double getBasic() { return basic; }
    public double getHra() { return hra; }
    public double getDa() { return da; }
    public double getAllowances() { return allowances; }

    public double calculateGross() {

        List<Double> components = Arrays.asList(basic, hra, da, allowances);

        return components.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
    
}

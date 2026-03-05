package com.model;


public class Payslip implements Cloneable {

    private Employee employee;
    private SalaryComponents salary;
    private String month;
    private double gross;
    private double pf;
    private double tax;
    
    private double netPay;

    public Payslip(String month, Employee employee, SalaryComponents salary) {
        this.employee = employee;
        this.salary = salary;
        this.month = month;
        calculateSalary();
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getMonth() {
        return month;
    }

    public double getNetPay() {
        return netPay;
    }
    
    private void calculateSalary() {

        gross = salary.calculateGross();

        pf = salary.getBasic() * 0.12;   // 12% PF
        tax = gross * 0.10;              // 10% Tax

        
        netPay = gross - (pf + tax);
    }

    @Override
    public String toString() {
        return "PAYSLIP\n" +
                "Employee ID : " + employee.getEmpId() + "\n" +
                "Employee Name : " + employee.getName() + "\n" +
                "Month : " + month + "\n" +
                "Net Pay : " + netPay;
    }

    // Deep Clone
    @Override
    public Payslip clone() {
        try {
            return (Payslip) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Payslip)) return false;

        Payslip p = (Payslip) obj;

        return employee.getEmpId().equals(p.employee.getEmpId())
                && month.equals(p.month)
                && netPay == p.netPay;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return employee.getEmpId().hashCode() + month.hashCode();
    }
}

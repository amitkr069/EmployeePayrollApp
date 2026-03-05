package com.model;

public class Payslip {

    private String month;
    private Employee employee;
    private SalaryComponents salary;

    private double pf;
    private double tax;
    private double netPay;

    public Payslip(String month, Employee employee, SalaryComponents salary) {
        this.month = month;
        this.employee = employee;
        this.salary = salary;

        calculateDeductions();
    }

    private void calculateDeductions() {

        double gross = salary.calculateGross();

        pf = salary.getBasic() * 0.12;
        tax = gross * 0.10;

        netPay = gross - (pf + tax);
    }

    @Override
    public String toString() {

        return "\n=========== PAYSLIP ===========\n" +
                "Month : " + month +
                "\nEmployee ID : " + employee.getEmpId() +
                "\nEmployee Name : " + employee.getName() +

                "\n\n----- Earnings -----" +
                "\nBasic Salary : " + salary.getBasic() +
                "\nHRA : " + salary.getHra() +
                "\nDA : " + salary.getDa() +
                "\nAllowances : " + salary.getAllowances() +

                "\n\n----- Deductions -----" +
                "\nPF : " + pf +
                "\nTax : " + tax +

                "\n\nNet Pay : " + netPay +
                "\n===============================";
    }
}

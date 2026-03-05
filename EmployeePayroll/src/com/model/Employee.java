package com.model;

public class Employee {

    private String empId;
    private String name;
    private String email;
    private String phone;

    private UserAccount account;   // Composition

    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }
    
    // getter methods
    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserAccount getAccount() {
        return account;
    }
   
    @Override
    public String toString() {
        return "Employee ID : " + empId +
               "\nName : " + name +
               "\nEmail : " + email +
               "\nPhone : " + phone +
               "\nUsername : " + account.getUsername();
    }
}

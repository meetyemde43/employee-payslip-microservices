package com.example.payslipService.dto;

public class PayslipResponse {
    private int empId;
    private String name;
    private int attendedDays;
    private double monthlySalary;

    public PayslipResponse(int empId, String name, int attendedDays, double monthlySalary) {
        this.empId = empId;
        this.name = name;
        this.attendedDays = attendedDays;
        this.monthlySalary = monthlySalary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getAttendedDays() {
        return attendedDays;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
}
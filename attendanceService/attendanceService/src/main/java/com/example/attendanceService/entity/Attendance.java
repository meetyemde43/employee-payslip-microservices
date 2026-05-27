package com.example.attendanceService.entity;

public class Attendance {

    private int empId;
    private int daysAttended;

    // Default constructor
    public Attendance() {
    }

    // Parameterized constructor
    public Attendance(int empId,
                      int daysAttended) {

        this.empId = empId;
        this.daysAttended = daysAttended;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(
            int daysAttended) {

        this.daysAttended = daysAttended;
    }
}
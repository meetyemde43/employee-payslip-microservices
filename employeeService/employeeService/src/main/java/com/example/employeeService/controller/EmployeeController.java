package com.example.employeeService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.employeeService.entity.Employee;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    List<Employee> employeeList =
            new ArrayList<>();

    // Add Employee
    @PostMapping("/add")
    public String addEmployee(
            @RequestBody Employee employee) {

        employeeList.add(employee);

        return "Employee Added Successfully";
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(
            @PathVariable("id") int id) {

        for (Employee emp : employeeList) {

            if (emp.getEmpId() == id) {
                return emp;
            }
        }

        return null;
    }
}
package com.example.payslipService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.payslipService.dto.PayslipResponse;
import com.example.payslipService.service.PayslipService;

@RestController
@CrossOrigin("*")
@RequestMapping("/payslip")
public class PayslipController {

    @Autowired
    private PayslipService service;

    @GetMapping("/{id}")
    public PayslipResponse getPayslip(
            @PathVariable("id") int id) {

        return service.calculateSalary(id);
    }
}
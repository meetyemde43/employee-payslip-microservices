package com.example.payslipService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.payslipService.dto.PayslipResponse;
import com.example.payslipService.model.Attendance;
import com.example.payslipService.model.Employee;

public class PayslipServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PayslipService payslipService;

    public PayslipServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateSalary() {

        Employee employee =
                new Employee();

        employee.setEmpId(1);
        employee.setName("Meet");
        employee.setBasicSalary(60000);

        Attendance attendance =
                new Attendance();

        attendance.setEmpId(1);
        attendance.setDaysAttended(25);

        when(restTemplate.getForObject(
                "http://localhost:8081/employee/1",
                Employee.class))
                .thenReturn(employee);

        when(restTemplate.getForObject(
                "http://localhost:8082/attendance/1",
                Attendance.class))
                .thenReturn(attendance);

        PayslipResponse response =
                payslipService.calculateSalary(1);

        assertEquals(
                50000,
                response.getMonthlySalary()
        );
    }
}
package com.example.payslipService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.payslipService.dto.PayslipResponse;
import com.example.payslipService.model.Attendance;
import com.example.payslipService.model.Employee;

@Service
public class PayslipService {
    private RestTemplate restTemplate = new RestTemplate();

    public PayslipResponse calculateSalary(int empId) {
        Employee employee = restTemplate.getForObject(
        				"http://localhost:8081/employee/" + empId, Employee.class);

        Attendance attendance = restTemplate.getForObject(
        				"http://localhost:8082/attendance/" + empId, Attendance.class);

        int totalWorkingDays = 30;

        double salary = (employee.getBasicSalary() / totalWorkingDays) * attendance.getDaysAttended();

        return new PayslipResponse(employee.getEmpId(), employee.getName(), attendance.getDaysAttended(),salary);
    }
}




//package com.example.payslipService.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.payslipService.dto.PayslipResponse;
//import com.example.payslipService.model.Attendance;
//import com.example.payslipService.model.Employee;
//
//@Service
//public class PayslipService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public PayslipResponse calculateSalary(
//            int empId) {
//
//        Employee employee =
//                restTemplate.getForObject(
//                        "http://localhost:8081/employee/" + empId,
//                        Employee.class);
//
//        Attendance attendance =
//                restTemplate.getForObject(
//                        "http://localhost:8082/attendance/" + empId,
//                        Attendance.class);
//
//        int totalWorkingDays = 30;
//
//        double salary =
//                (employee.getBasicSalary()
//                        / totalWorkingDays)
//                        * attendance.getDaysAttended();
//
//        return new PayslipResponse(
//                employee.getEmpId(),
//                employee.getName(),
//                attendance.getDaysAttended(),
//                salary
//        );
//    }
//}
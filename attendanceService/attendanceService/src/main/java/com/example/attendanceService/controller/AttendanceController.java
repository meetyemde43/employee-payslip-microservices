package com.example.attendanceService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.attendanceService.entity.Attendance;

@RestController
@CrossOrigin("*")
@RequestMapping("/attendance")
public class AttendanceController {

    List<Attendance> attendanceList =
            new ArrayList<>();

    // Add attendance
    @PostMapping("/add")
    public String addAttendance(
            @RequestBody Attendance attendance) {

        attendanceList.add(attendance);

        return "Attendance Added Successfully";
    }

    // Get attendance by employee id
    @GetMapping("/{id}")
    public Attendance getAttendance(
            @PathVariable("id") int id) {

        for (Attendance att :
                attendanceList) {

            if (att.getEmpId() == id) {
                return att;
            }
        }

        return null;
    }
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public EmployeeDTO getEmployee() {

        EmployeeDTO employee = new EmployeeDTO();

        employee.setName("Rahul");
        employee.setEmail("rahul@gmail.com");
        employee.setSalary(50000);
        employee.setDepartment("IT");

        return employee;
    }
}
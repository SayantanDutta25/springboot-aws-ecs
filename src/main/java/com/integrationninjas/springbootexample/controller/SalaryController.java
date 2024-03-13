package com.integrationninjas.springbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integrationninjas.springbootexample.entity.Salary;
import com.integrationninjas.springbootexample.service.SalaryService;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Double> getSalary(@PathVariable Long employeeId) {
        double salary = salaryService.calculateSalary(employeeId);
        return ResponseEntity.ok(salary);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Void> updateSalary(@PathVariable Long employeeId, @RequestParam double newSalary) {
        salaryService.updateSalary(employeeId, newSalary);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }
}

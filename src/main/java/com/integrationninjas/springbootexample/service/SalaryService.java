package com.integrationninjas.springbootexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrationninjas.springbootexample.entity.Salary;
import com.integrationninjas.springbootexample.repository.SalaryRepository;


@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    // Other methods for salary management
}


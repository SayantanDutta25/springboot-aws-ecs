package com.integrationninjas.springbootexample.service;

import java.util.List;

import com.integrationninjas.springbootexample.dto.SalaryDto;


public interface SalaryService {

   // String createSalary(SalaryDto salaryDto);

    List<SalaryDto> getSalary();

	double calculateSalary(Long employeeId);
}


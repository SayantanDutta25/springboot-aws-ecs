package com.employee.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.management.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Integer>{

}

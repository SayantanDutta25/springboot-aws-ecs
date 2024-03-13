package com.integrationninjas.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrationninjas.springbootexample.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

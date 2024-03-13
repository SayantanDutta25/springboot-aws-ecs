package com.integrationninjas.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrationninjas.springbootexample.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

}

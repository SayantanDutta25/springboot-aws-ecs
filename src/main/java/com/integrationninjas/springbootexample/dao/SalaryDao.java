package com.integrationninjas.springbootexample.dao;

import com.integrationninjas.springbootexample.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDao extends JpaRepository<Salary, Long> {

}



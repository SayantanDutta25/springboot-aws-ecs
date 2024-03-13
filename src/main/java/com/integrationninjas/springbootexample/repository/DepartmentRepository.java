package com.integrationninjas.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrationninjas.springbootexample.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

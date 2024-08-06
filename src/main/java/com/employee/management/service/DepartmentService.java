package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Department;
import com.employee.management.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    // fetching all departments
    public List<Department> getAllDepartments() {
        logger.info("Fetching all departments");
        List<Department> depts = (List<Department>) departmentRepository.findAll();
        logger.info("Fetched {} departments", depts.size());
        return depts;
    }

    // fetching department by id
    public Optional<Department> getDepartment(int id) {
        logger.info("Fetching department with id {}", id);
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            logger.info("Fetched department: {}", department.get());
        } else {
            logger.warn("Department with id {} not found", id);
        }
        return department;
    }

    // inserting department
    public void addDepartment(Department d) {
        logger.info("Adding department: {}", d);
        departmentRepository.save(d);
        logger.info("Department added: {}", d);
    }

    // updating department by id
    public void updateDepartment(Department d, int id) {
        if (id == d.getDepartment_ID()) {
            logger.info("Updating department with id {}: {}", id, d);
            departmentRepository.save(d);
            logger.info("Department updated: {}", d);
        } else {
            logger.warn("Department ID mismatch: {} != {}", id, d.getDepartment_ID());
        }
    }

    // deleting all departments
    public void deleteAllDepartment() {
        logger.info("Deleting all departments");
        departmentRepository.deleteAll();
        logger.info("All departments deleted");
    }

    // deleting department by id
    public void deleteDepartmentByID(int id) {
        logger.info("Deleting department with id {}", id);
        departmentRepository.deleteById(id);
        logger.info("Department with id {} deleted", id);
    }

    // patching/updating department by id
    public void patchDepartment(Department d, int id) {
        if (id == d.getDepartment_ID()) {
            logger.info("Patching department with id {}: {}", id, d);
            departmentRepository.save(d);
            logger.info("Department patched: {}", d);
        } else {
            logger.warn("Department ID mismatch: {} != {}", id, d.getDepartment_ID());
        }
    }
}

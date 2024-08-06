package com.employee.management.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // fetching all employees
    public List<Employee> getAllEmployees(){
        logger.info("Fetching all employees");
        List<Employee> emps = (List<Employee>)employeeRepository.findAll(); 
        logger.info("Fetched {} employees", emps.size());
        return emps;
    }

    // fetching employee by id
    public Optional<Employee> getEmployee(int id){
        logger.info("Fetching employee with id {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            logger.info("Fetched employee: {}", employee.get());
        } else {
            logger.warn("Employee with id {} not found", id);
        }
        return employee;
    }

    // inserting employee
    public void addEmployee(Employee e) {
        logger.info("Adding employee: {}", e);
        employeeRepository.save(e);
        logger.info("Employee added: {}", e);
    }

    // updating employee by id
    public void updateEmployee(Employee emp, int id){
        if(id == emp.getEmployeeID()) {
            logger.info("Updating employee with id {}: {}", id, emp);
            employeeRepository.save(emp);
            logger.info("Employee updated: {}", emp);
        } else {
            logger.warn("Employee ID mismatch: {} != {}", id, emp.getEmployeeID());
        }
    }

    // deleting all employees
    public void deleteAllEmployees(){
        logger.info("Deleting all employees");
        employeeRepository.deleteAll();
        logger.info("All employees deleted");
    }

    // deleting employee by id
    public void deleteEmployeeByID(int id){
        logger.info("Deleting employee with id {}", id);
        employeeRepository.deleteById(id);
        logger.info("Employee with id {} deleted", id);
    }

    // patching/updating employee by id
    public void patchEmployee(Employee emp, int id) {
        if(id == emp.getEmployeeID()) {
            logger.info("Patching employee with id {}: {}", id, emp);
            employeeRepository.save(emp);
            logger.info("Employee patched: {}", emp);
        } else {
            logger.warn("Employee ID mismatch: {} != {}", id, emp.getEmployeeID());
        }
    }

    public Employee getHighestPaidEmployee() {
        logger.info("Fetching the highest paid employee");
        List<Employee> employees = (List<Employee>)employeeRepository.findAll(); 

        if (employees.isEmpty()) {
            logger.error("No employees found");
            throw new NoSuchElementException("No employees found");
        }

        Employee highestPaidEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary().getAmount() > highestPaidEmployee.getSalary().getAmount()) {
                highestPaidEmployee = employee;
            }
        }

        logger.info("Highest paid employee: {}", highestPaidEmployee);
        return highestPaidEmployee;
    }
}

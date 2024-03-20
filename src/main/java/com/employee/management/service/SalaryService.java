package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Employee;
import com.employee.management.model.Salary;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.SalaryRepository;

import jakarta.transaction.Transactional;

@Service
public class SalaryService {

	@Autowired
	private SalaryRepository salaryRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	// fetching all salary
	public List<Salary> getAllSalaries() {
		List<Salary> sal = (List<Salary>) salaryRepository.findAll();
		return sal;
	}

	// fetching salary by id
	public Optional<Salary> getSalary(int id) {
		return salaryRepository.findById(id);
	}

	// inserting salary
	public void addSalary(Salary s) {
		salaryRepository.save(s);
	}

	// updating salary by id
	public void updateSalary(Salary s, int id) {
		if (id == s.getSalary_ID()) {
			salaryRepository.save(s);
		}
	}

	// deleting all salary
	public void deleteAllSalary() {
		salaryRepository.deleteAll();
	}

	// deleting salary by id
	public void deleteSalaryByID(int id) {
		salaryRepository.deleteById(id);
	}

	// patching/updating salary by id
	public void patchSalary(Salary s, int id) {
		if (id == s.getSalary_ID()) {
			salaryRepository.save(s);
		}
	}

	@Transactional
	public void incrementSalaries(double percentage) {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		for (Employee employee : employees) {
			Salary salary = employee.getSalary();
			if (salary != null) {
				double currentAmount = salary.getAmount();
				double incrementAmount = (currentAmount * percentage) / 100;
				double newAmount = currentAmount + incrementAmount;
				salary.setIncreasedSalary(newAmount); // Set the incremented salary to the new column
			}
		}

		employeeRepository.saveAll(employees);
	}
}

package com.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Salary;
import com.employee.management.service.SalaryService;

@RestController
public class SalaryController {
	
	static final Logger logger  = LogManager.getLogger(SalaryController.class.getName());
	
	@Autowired
	private SalaryService salaryService;
	
	// displaying list of all salary
		@GetMapping("/salary")
		public List<Salary> getAllSalary(){
			return salaryService.getAllSalaries();
		}

		// displaying salary by id
		@GetMapping("/salary/{id}")
		public Optional<Salary> getSalary(@PathVariable int id){
			return salaryService.getSalary(id);
		}
		
		// inserting salary
		@PostMapping("/salary")
		public void addSalary(@RequestBody Salary salary){
			salaryService.addSalary(salary);
		}

		//updating salary by id
		@PutMapping("/salary/{id}")
		public void updateSalary(@RequestBody Salary s, @PathVariable int id){
			salaryService.updateSalary(s, id);
		}
		
		// deleting all salary
		@DeleteMapping("/salary")
		public void deleteAllSalary(){
			salaryService.deleteAllSalary();
		}

		// deleting salary by id
		@DeleteMapping("salary/{id}")
		public void deleteSalaryByID(@RequestBody Salary s, @PathVariable int id){
			salaryService.deleteSalaryByID(id);
		}

		// updating/ patching salary by id
		@PatchMapping("salary/{id}")
		public void patchSalaryByID(@RequestBody Salary s, @PathVariable int id) {
			salaryService.patchSalary(s, id);
		}
}

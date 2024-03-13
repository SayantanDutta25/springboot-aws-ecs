package com.integrationninjas.springbootexample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.integrationninjas.springbootexample.dao.SalaryDao;
import com.integrationninjas.springbootexample.dto.SalaryDto;
import com.integrationninjas.springbootexample.entity.Salary;
import com.integrationninjas.springbootexample.service.SalaryService;

public class SalaryServiceImpl implements SalaryService {

	@Autowired

	SalaryDao salaryDao;

	public List<SalaryDto> getAllSalaries() {
	    	List<Salary> salaryList = salaryDao.findAll();
	    	List<SalaryDto> dtoList = new ArrayList<>();	    
	// return SalaryDao.findAll();
	return dtoList;

}
}

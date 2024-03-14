package com.employee.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {

	@Id
	@Column(name="salary_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salary_ID;
	private String range;
	private int amount;
	
	public Salary() {
	
	}
	
	public Salary(int salaryID){
		super();
		this.salary_ID = salaryID;
	}
	
	public Salary(int salaryID, String range, int amount) {
		super();
		this.salary_ID = salaryID;
		this.range = range;
		this.amount = amount;
	}

	public int getSalary_ID() {
		return salary_ID;
	}

	public void setSalary_ID(int salary_ID) {
		this.salary_ID = salary_ID;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}

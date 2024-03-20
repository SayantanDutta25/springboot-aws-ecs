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
	
	@Column(name = "`range`") // Enclose 'range' in backticks to avoid conflict with reserved keyword
    private String range;
	
	private double amount;
	
    @Column(name = "increased_salary")
    private double increasedSalary;
	
	public Salary() {
	
	}
	
	public Salary(int salaryID){
		super();
		this.salary_ID = salaryID;
	}
	
	public Salary(int salaryID, String range, int amount, int increasedSal) {
		super();
		this.salary_ID = salaryID;
		this.range = range;
		this.amount = amount;
		this.increasedSalary = increasedSal;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getIncreasedSalary() {
        return increasedSalary;
    }
	
	public void setIncreasedSalary(double increasedSalary) {
        this.increasedSalary = increasedSalary;
    }
	
	public static class IncrementRequest {
        private double percentage;

        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }
    }

}

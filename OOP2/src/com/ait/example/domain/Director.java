package com.ait.example.domain;

public class Director extends Manager{
	
	private double budget;
	
	public Director(int employeeID, String employeeName, String employeeSSN, 
			double employeeSalary, String deptName, double budget) {
		super(employeeID, employeeName, employeeSSN, employeeSalary, deptName);
		this.budget = budget;
	}
	
	public double getBudget() {
		return this.budget;
	}

	@Override
	public String toString(){

		return super.toString() + "\nBudget: " + budget;
	}
}

package com.ait.example.domain;

import java.text.NumberFormat;

public class Employee {
	
	private int employeeID;
	private String employeeName;
	private String employeeSSN;
	private double employeeSalary;

	public Employee(int employeeID, String employeeName, String employeeSSN, double employeeSalary) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeSSN = employeeSSN;
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		
		if(!employeeName.isEmpty() || employeeName != null) {
			this.employeeName = employeeName;
		}
	}

	public String getEmployeeSSN() {
		return employeeSSN;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}
	
	public void raisSalarty(double increase) {
		
		if(increase > 0) {
			this.employeeSalary += increase;	
		}
	}

	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();
		sb.append("Employee ID: " + employeeID +"\n")
				.append("Employee Name: " + employeeName+"\n").
				append("Employee Security Number: "+employeeSSN+"\n").
				append("Employee Salary: "+NumberFormat.getCurrencyInstance().format(employeeSalary));
		return sb.toString();
	}
}

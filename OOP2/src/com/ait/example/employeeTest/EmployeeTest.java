package com.ait.example.employeeTest;

import com.ait.example.business.EmployeeStockPlan;
import com.ait.example.domain.Employee;
import com.ait.example.domain.Engineer;
import com.ait.example.domain.Manager;

import java.text.NumberFormat;

import com.ait.example.domain.Admin;
import com.ait.example.domain.Director;

public class EmployeeTest {

	public static void printEmployee(Employee emp) {
		System.out.println("Employee type: " + emp.getClass().getSimpleName());
		System.out.println(emp.toString());
	}
	public static void printEmployee(Employee employee, EmployeeStockPlan employeeStockPlan){
		printEmployee(employee);
		System.out.println("Stock options: " + employeeStockPlan.grantStock(employee));
	}
	public static void main(String[] args) {
		
		Engineer engineer = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
		Manager manager = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
		Admin admin = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);
		Director director = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);
		EmployeeStockPlan employeeStockPlan = new EmployeeStockPlan();
		/*
		 * manager.raisSalarty(10000);
		 * manager.setEmployeeName("Barbara Johnson-Smythe");
		 * 
		 * printEmployee(engineer); printEmployee(manager); printEmployee(admin);
		 * printEmployee(director);
		 */
		
		manager.addEmployee(engineer);
		manager.addEmployee(admin);
		manager.addEmployee(director);
		System.out.println(manager.findEmployee(director));
		manager.removeEmployee(admin);
		System.out.println(manager.findEmployee(director));

		printEmployee(manager, employeeStockPlan);
	}

}

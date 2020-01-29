package com.ait.example.domain;

public class Manager extends Employee{

	private String deptName;
	private  Employee [] staff;
	private static int employeeCount;
	
	
	public Manager(int employeeID, String employeeName, String employeeSSN, double employeeSalary, 
			String deptName) {
		super(employeeID, employeeName, employeeSSN, employeeSalary);
		this.deptName = deptName;
		this.staff = new Employee[20];
	}
	
	public int findEmployee(Employee emp) {

		
		for(int i =0; i < staff.length; i++) {
			
			if(emp.equals(staff[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean addEmployee(Employee emp) {
		
		if(findEmployee(emp) != -1) {
			return false;
		}
		staff[employeeCount] = emp;
		employeeCount ++;
		
		return true;
	}
	
	public boolean removeEmployee(Employee emp) {
		boolean temp = false;
		Employee[] tempArrayOfEmployees = new Employee[20];
		int countOfEmployees = 0;
		
		for (int i = 0; i < employeeCount; i++) {
			
			if (staff[i].getEmployeeID() != emp.getEmployeeID()) {
				tempArrayOfEmployees[countOfEmployees] = staff[i];
				countOfEmployees++;
			}
			temp = true;

		}
		staff = tempArrayOfEmployees.clone();
		
		return temp;
	}
	
	public void printStaffDetails() {
		System.out.println("Manager name: " + this.getEmployeeName());
		for (int i = 0; i < staff.length; i++) {
			System.out.println("Staff name: " + staff[i].getEmployeeName() + " ID: " + staff[i].getEmployeeID());
		}
	}
	public String getDeptName() {
		return this.deptName;
	}

	@Override
	public String toString(){
		return super.toString() + "\nDepartment: "+ deptName;
	}
}

package com.ait.dataTableExample;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Person {

	private String name;
	private String department;
	private int age;
	private double salary;
	boolean canEdit;
	
	
	public Person() {}
	public Person(String name, String department, int age, double salary) {
		
		this.name = name;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}
	
	public boolean isGetEdit() {
		return canEdit;
	}
	public void setCandEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
}

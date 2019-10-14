package com.ait.dataTableExample;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class PersonCollection {
	
	private  ArrayList<Person> emp = new ArrayList<Person>() {{
		add(new Person("John", "Marketing", 30, 2000.0));
		add(new Person("Robert", "Marketing", 35, 3000.0));
		add(new Person("Mark", "Sales", 25, 2500.0));
	}};
	
	public ArrayList<Person> getEmps(){
		return emp;
	}
	public void addEmp(String name, String department, int age, double salary) {
		
		Person p = new Person(name, department, age, salary);
		emp.add(p);
	}
	public void setEmp(ArrayList<Person> emp) {
		this.emp = emp;
	}
	public String editSalary(Person p) {
		p.setCandEdit(true);
		return null;
	}
	public void saveAction() {
		for (Person person : emp) {
			person.setCandEdit(false);
		}
	}
}

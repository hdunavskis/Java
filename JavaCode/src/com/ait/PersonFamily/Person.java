package com.ait.PersonFamily;

public class Person {

	private int age;
	private String name;
	private String address;
	private static int count;
	
	
	
	public Person(int age, String name, String address) {
		this.age = age;
		this.name = name;
		this.address = address;
		count++;
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public static int getCount() {
		return count;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", address=" + address + "]";
	}
}

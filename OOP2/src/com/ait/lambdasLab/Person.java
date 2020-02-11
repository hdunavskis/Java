package com.ait.lambdasLab;

class Person {

	private int age;
	private String name;
	private double height;
	
	
	Person(int age, String name, double height) {
		super();
		this.age = age;
		this.name = name;
		this.height = height;
	}
	
	public Integer getAge() {
		return this.age;
	}
	public String getName() {
		return name;
	}
	public Double getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getAge() + " " + getHeight();
	}
	
}

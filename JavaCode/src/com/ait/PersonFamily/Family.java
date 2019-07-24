package com.ait.PersonFamily;

public class Family {

	public static void main(String[] args) {
		
		Person john = new Person(22, "John", "Dublin");
		Person ann = new Person(25, "Ann", "Galway");
		
		System.out.println(john.toString());
		System.out.println(ann.toString());
		System.out.println(Person.getCount());
	}

}

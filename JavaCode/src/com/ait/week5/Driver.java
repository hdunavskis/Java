package com.ait.week5;

public class Driver {

	public static void main(String[] args) {
		
		Phone samsung = new Phone();
		System.out.println(samsung.toString());
		
		Phone iPhone = new Phone("999", "Jhon", 88.5);
		System.out.println(iPhone.toString());
		
		iPhone.setOwnersName("Tom");
		iPhone.setPhoneNumber("110");
		iPhone.setPrice(110.5);
		
		System.out.println(iPhone.toString());
	}

}

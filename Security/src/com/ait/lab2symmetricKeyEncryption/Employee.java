package com.ait.lab2symmetricKeyEncryption;

import java.io.Serializable;

public class Employee implements Serializable{

	private String name;
	private String address;
	private String telNumber;
	
	public Employee(String name, String address, String telNumber) {
		super();
		this.name = name;
		this.address = address;
		this.telNumber = telNumber;
	}
	
	public String getName() {
		return this.name;
	}
}

package com.ait.week5;

public class Phone {
	
	private String phoneNumber;
	private String ownersName;
	private double price;
	
	
	public Phone() {};

	public Phone(String phoneNumber, String ownersName, double price) {
		
		this.phoneNumber = phoneNumber;
		this.ownersName = ownersName;
		this.price = price;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOwnersName() {
		return ownersName;
	}
	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + ", ownersName=" + ownersName + ", price=" + price + "]";
	}
	
	

}

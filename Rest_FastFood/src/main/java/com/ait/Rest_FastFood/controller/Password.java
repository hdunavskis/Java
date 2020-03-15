package com.ait.Rest_FastFood.controller;

public class Password {
	
	private String passw;
	private String salt;

	public Password(String password, String salt) {
		this.passw = password;
		this.salt = salt;
	}
	
	public String getPassword() {
		return passw;
	}

	public String getSalt() {
		return salt;
	}
}

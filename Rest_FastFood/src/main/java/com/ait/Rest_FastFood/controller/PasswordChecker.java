package com.ait.Rest_FastFood.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Pattern;

public class PasswordChecker {
	
	private String userInputPassword;
	private MessageDigest messageDigest;
	private byte[] salt;
	private String hashedPassword;

	private PasswordChecker() {}
	private PasswordChecker(String userInputPassword) {
		
		this.userInputPassword = userInputPassword; 
	}
	public static PasswordChecker createPasswordChecker() {
		return new PasswordChecker();
	}
	public static PasswordChecker createPasswordChecker(String userInput) {
		return new PasswordChecker(userInput);
	}
	public boolean generatePassword() {
		randomGeneratedSalt();
		hashThePassword();
			
		return true;		
	}
	private void randomGeneratedSalt() {
		SecureRandom random = new SecureRandom();
		salt = new byte[14];
		random.nextBytes(salt);
	}
	
	private void hashThePassword() {
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update((userInputPassword + getSalt()).getBytes());
			
			byte[] digest = messageDigest.digest();
			
			hashedPassword = Base64.getEncoder().encodeToString(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkIfPasswordsMatch(String userInputpassword, String dbSalt, String dbPassword) {
		
		try {
			
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update((userInputpassword + dbSalt).getBytes());
			
			byte[] digest = messageDigest.digest();
			
			String password = Base64.getEncoder().encodeToString(digest);

			return password.equals(dbPassword);
			

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getSalt() {
		return Base64.getEncoder().encodeToString(salt);
	}

	public String getHashedPassword() {
		return hashedPassword;
	}	 
}

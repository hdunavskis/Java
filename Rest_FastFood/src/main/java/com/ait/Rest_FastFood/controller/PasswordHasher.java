package com.ait.Rest_FastFood.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Pattern;

public class PasswordHasher {

	private PasswordHasher() {}
	
	public static Password generatePassword(String password) {
		String salt = randomGeneratedSalt();
		String passw = hashThePassword(password, salt);
			
		return new Password(passw, salt);		
	}
	private static String randomGeneratedSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[14];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	private static String hashThePassword(String password, String salt) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update((password + salt).getBytes());
			
			byte[] digest = messageDigest.digest();
			
			return Base64.getEncoder().encodeToString(digest);
			
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}

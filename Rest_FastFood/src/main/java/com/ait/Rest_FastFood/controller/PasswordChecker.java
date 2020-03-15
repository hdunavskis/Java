package com.ait.Rest_FastFood.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordChecker {
	
	private PasswordChecker() {}
	
public static boolean checkIfPasswordsMatch(String userInputpassword, String dbSalt, String dbPassword) {
		
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update((userInputpassword + dbSalt).getBytes());

			byte[] digest = messageDigest.digest();

			String password = Base64.getEncoder().encodeToString(digest);

			return password.equals(dbPassword);

		} catch (NoSuchAlgorithmException e) {
			return false;
		}
	}

}

package com.ait.integrationTests;

import java.util.Base64;

public class AuthHelper {
	private AuthHelper() {}
	
	public static String makeBasicAuthHeader(final String username, final String password) {
		final String usernameAndPassword = username + ":" + password;
		return "BASIC " + new String(Base64.getEncoder().encode(usernameAndPassword.getBytes()));
	}
}

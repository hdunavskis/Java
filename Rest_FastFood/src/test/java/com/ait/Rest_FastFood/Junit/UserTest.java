package com.ait.Rest_FastFood.Junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.ait.Rest_FastFood.controller.Password;
import com.ait.Rest_FastFood.controller.PasswordChecker;
import com.ait.Rest_FastFood.controller.PasswordHasher;
import com.ait.Rest_FastFood.model.User;

public class UserTest {
	
	private Password password;
	private User user;
	

	@Before
	public void init() {
		
		user = new User();	
		password = PasswordHasher.generatePassword("password");
		user.setPassword(password.getPassword());
		user.setSalt(password.getSalt());
		user.setUserType("customer");
	}
	@Test
	public void test_set_user_password() {
		
		assertTrue(PasswordChecker.checkIfPasswordsMatch("password", user.getSalt(), user.getPassword()));
	
	}
	@Test
	public void test_user_type_customer() {
		
		assertEquals("customer", user.getUserType());
		
	}
}

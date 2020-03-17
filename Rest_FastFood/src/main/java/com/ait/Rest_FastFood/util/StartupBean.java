package com.ait.Rest_FastFood.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.ait.Rest_FastFood.controller.Password;
import com.ait.Rest_FastFood.controller.PasswordHasher;
import com.ait.Rest_FastFood.data.UserDAO;
import com.ait.Rest_FastFood.model.User;

@Startup
@Singleton
public class StartupBean {
	
	@Inject 
	private UserDAO userDAO;
	
	private static final String CUSTOMER_USERNAME = "customer";
	private static final String CUSTOMER_PASSWORD = "password";
	private static final String STAFF_USERNAME = "staff";

	@PostConstruct
	public void createAdminUser() {
		if (userDAO.getCustomer(CUSTOMER_USERNAME) == null) {
			
			Password password = PasswordHasher.generatePassword(CUSTOMER_PASSWORD);
			User customer = new User();
			customer.setUserName(CUSTOMER_USERNAME);
			customer.setPassword(password.getPassword());
			customer.setSalt(password.getSalt());
			customer.setUserType("customer");
			userDAO.save(customer);
		}
		if (userDAO.getCustomer(STAFF_USERNAME) == null) {
			
			Password password2 = PasswordHasher.generatePassword(CUSTOMER_PASSWORD);
			User staff = new User();
			staff.setUserName(STAFF_USERNAME);
			staff.setPassword(password2.getPassword());
			staff.setSalt(password2.getSalt());
			staff.setUserType("staff");
			userDAO.save(staff);
		}
		
	}
}

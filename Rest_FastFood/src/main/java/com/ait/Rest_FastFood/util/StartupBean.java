package com.ait.Rest_FastFood.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.ait.Rest_FastFood.controller.Password;
import com.ait.Rest_FastFood.controller.PasswordHasher;
import com.ait.Rest_FastFood.data.FoodDAO;
import com.ait.Rest_FastFood.data.UserDAO;
import com.ait.Rest_FastFood.model.Food;
import com.ait.Rest_FastFood.model.User;

@Startup
@Singleton
public class StartupBean {
	
	@Inject 
	private UserDAO userDAO;
	@Inject
	private FoodDAO foodDAO;
	
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
		if(foodDAO.getAllFood().isEmpty()) {
			List<Food> food = new ArrayList<>();
			food.add(new Food("Noodles with salad",9.2,"description","food1.png"));
			food.add(new Food("Oven baked pasta",11.75,"description","food2.png"));
			food.add(new Food("Fresh Salmon",22.50,"description","food3.png"));
			food.add(new Food("Fresh Trout",18.40,"description","food4.png"));
			food.add(new Food("Ceasar salad wrap",8.90,"description","food5.png"));
			food.add(new Food("Healthy dinner",14.50,"description","food6.png"));
			foodDAO.insertFood(food);
		}
		
	}
}

package com.ait.Rest_FastFood.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class Customer extends User{

	public Customer() {
		super();
	}

	public Customer(int userID, String userName, String password, String userType) {
		super(userID, userName, password, userType);
	}
	
	

}

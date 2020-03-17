package com.ait.Rest_FastFood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String password;
	private String salt;
	private String userType;
	
	
	public User() {}
	public User(int userID, String userName, String password, String userType) {
		this.userId = userID;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public int getUserID() {
		return userId;
	}

	public void setUserID(int userID) {
		this.userId = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userId + ", userName=" + userName + ", userType=" + userType
				+ "]";
	}
}

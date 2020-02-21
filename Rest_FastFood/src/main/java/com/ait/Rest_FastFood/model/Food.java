package com.ait.Rest_FastFood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
	
	@Id
	private String name;
	private double price;
	private String description;
	private String picture;
	
	public Food() {}
	
	public Food(String name, double price, String description, String picture) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", description=" + description + ", picture=" + picture
				+ "]";
	}
}

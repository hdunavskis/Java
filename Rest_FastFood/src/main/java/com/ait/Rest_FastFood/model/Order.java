package com.ait.Rest_FastFood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private int foodID;
	private boolean isReady;
	private boolean isPaid;
	
	public Order() {}
	public Order(int orderId, int foodID, boolean isReady, boolean isPaid) {
		super();
		this.orderId = orderId;
		this.foodID = foodID;
		this.isReady = isReady;
		this.isPaid = isPaid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", foodID=" + foodID + ", isReady=" + isReady + ", isPaid=" + isPaid + "]";
	}
	
	
}

package com.ait.Rest_FastFood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private String foodName;
	private int amount;
	private String noteToKitchenStaff;
	private boolean isReady;
	private boolean isPaid;
	
	public Order() {}
	
	public Order(int orderId, String foodName, int amount, String noteToKitchenStaff, boolean isReady, boolean isPaid) {
		super();
		this.orderId = orderId;
		this.foodName = foodName;
		this.amount = amount;
		this.noteToKitchenStaff = noteToKitchenStaff;
		this.isReady = isReady;
		this.isPaid = isPaid;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public boolean getIsReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public boolean getIsPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNoteToKitchenStaff() {
		return noteToKitchenStaff;
	}

	public void setNoteToKitchenStaff(String noteToKitchenStaff) {
		this.noteToKitchenStaff = noteToKitchenStaff;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", foodName=" + foodName + ", amount=" + amount + ", noteToKitchenStaff="
				+ noteToKitchenStaff + ", isReady=" + isReady + ", isPaid=" + isPaid + "]";
	}
}

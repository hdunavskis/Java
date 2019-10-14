package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Item {
	
	private int productID;
	private int quantity;
	
	public Item() {}
	
	public Item(int productID) {
		this.productID = productID;
		this.quantity = 1;
	}
	
	public Item(int productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [productID=" + productID + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == Item.class) {
			Item other = (Item) obj;			
			if(this.productID == other.getProductID()) {
				return true;
			}			
		}
		
		return false;
	}
}

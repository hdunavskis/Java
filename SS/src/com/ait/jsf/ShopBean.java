package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ShopBean {

	private int productID;
	private int quantity;
	
	
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

	public String addHandler() {
		
		CartBean cart = Helper.getBean("cartBean", CartBean.class);
		cart.addItemToCart(productID, quantity);
		return null;
	}
	
	public String removeHandler() {
		
		CartBean cart = Helper.getBean("cartBean", CartBean.class);
		cart.removeItemFromCart(productID);
		return null;
	}
}

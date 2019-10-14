package com.ait.jsf;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CartBean {

	private ArrayList<Item> items = new ArrayList<Item>();
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItemToCart(int productID, int quality) {
		
		Item i = new Item(productID, quality);
		items.add(i);
	}
	
	public void removeItemFromCart(int productID) {
		
		Item i = new Item(productID);
		items.remove(i);
	}
	
	
	public int getItemCount() {
		
		return items.size();
	}
	
	
}

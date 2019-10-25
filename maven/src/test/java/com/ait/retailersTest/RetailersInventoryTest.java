package com.ait.retailersTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import com.ait.retailers.BiggestBazarRetail;
import com.ait.retailers.Inventory;
import com.ait.retailers.Item;
import com.ait.retailers.Offer;
import com.ait.retailers.PublicAddressSystem;

class RetailersInventoryTest {
	private BiggestBazarRetail bbr;
	private Item it;
	private Inventory inv;
	private PublicAddressSystem pas;
	private ArrayList<Item> expired;
	
	@BeforeEach
	void setUp() {
		pas = mock(PublicAddressSystem.class);
		inv = mock(Inventory.class);
		it = new Item("barcode", "name", 30.0, 20.0);
		bbr = new BiggestBazarRetail(inv, pas);
		expired = new ArrayList<>();
	}
	
	@Test
	void issueDiscountForItemsExpireIn30DaysTest() {
		expired.add(it);
		//database call
		when(inv.getItemsExpireInAMonth()).thenReturn(expired);
		//update count
		when(inv.itemsUpdated()).thenReturn(1);
		//test
		assertEquals(1, bbr.issueDiscountForItemsExpireIn30Days(0.3));
		//verify update
		//if method called 2 times can use isA(Item.class)
		verify(inv, new Times(1)).update(it, 21.0);
		verify(pas, new Times(1)).announce(isA(Offer.class));
	}
	@Test
	void getItemsExpireInaMonthTest() {
		expired.add(it);
		//database call
		when(inv.getItemsExpireInAMonth()).thenReturn(expired);
		when(inv.itemsUpdated()).thenReturn(1);
		
		assertEquals(1, bbr.issueDiscountForItemsExpireIn30Days(0.5));
		
		verify(inv, new Times(0)).update(it, 15.0);
		verify(pas, new Times(0)).announce(isA(Offer.class));
		
	}
	@Test
	void twoItemsQualifyForDiscoutTest() {
		Item a = new Item("123", "TV", 100.0, 20.0);
		Item b = new Item("barcode", "name", 200.0, 20.0);
		expired.add(it);
		expired.add(a);
		expired.add(b);
		
		//database call
		when(inv.getItemsExpireInAMonth()).thenReturn(expired);
		when(inv.itemsUpdated()).thenReturn(3);
		
		assertEquals(3, bbr.issueDiscountForItemsExpireIn30Days(0.5));
		//item calss with any double value
		verify(inv, new Times(2)).update(isA(Item.class), anyDouble());
		verify(pas, new Times(2)).announce(isA(Offer.class));
	
	}
}

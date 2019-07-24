package com.ait.week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneTest {
	Phone p = new Phone("999", "Tom", 10);
	@Test
	void testGetOwnerName() {
		
		assertEquals("Tom", p.getOwnersName());
	}
	@Test
	void testGetPhoneNumber() {
		assertEquals("999", p.getPhoneNumber());
	}
	@Test
	void testGetPhonePrice() {
		assertEquals(10.0, p.getPrice());
	}
	@Test
	void testSetOwnerName() {
		p.setOwnersName("John");
		assertEquals("John", p.getOwnersName());
	}
	@Test
	void testSetPhoneNumber() {
		p.setPhoneNumber("111");
		assertEquals("111", p.getPhoneNumber());
	}
	@Test
	void testSetPhonePrice() {
		p.setPrice(99);;
		assertEquals(99.0, p.getPrice());
	}

}

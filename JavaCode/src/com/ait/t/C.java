package com.ait.t;

import java.util.Date;

import com.ait.inheritance.B;

final class C extends B{
	
	private final Date dateRef = new Date();
	
	public void t() {
		 // creates a new Date with the same time
	}

	public Date getDate() {
		
		return dateRef;//new Date(dateRef.getTime());
	}
}

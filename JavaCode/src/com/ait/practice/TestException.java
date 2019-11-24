package com.ait.practice;

import java.io.IOException;

public class TestException extends IOException{

	private static final long serialVersionUID = 1L;

	public TestException(String error){
		super(error);
		
	}

}

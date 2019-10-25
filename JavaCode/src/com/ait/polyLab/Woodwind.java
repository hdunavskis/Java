package com.ait.polyLab;

public class Woodwind extends Wind{

	@Override
	public void play() {
		System.out.println("Woodwind.play()");
	}

	@Override
	public String what() {
		return "Woodwind";
	}

}

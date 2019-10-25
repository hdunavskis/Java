package com.ait.polyLab;

public class Stringed implements IInstrument{

	@Override
	public void play() {
		System.out.println("Stringed.play()");
	}

	@Override
	public String what() {
		return "Stringed";
	}

	@Override
	public void adjust() {
		System.out.println("Stringed.adjust()");
	}
	
}

package com.ait.polyLab;

public class Percussion implements IInstrument{

	@Override
	public void play() {
		System.out.println("Percussion.play()");
	}

	@Override
	public String what() {
		return "Percussion";
	}

	@Override
	public void adjust() {
		System.out.println("Percussion.adjust()");
	}

		
}

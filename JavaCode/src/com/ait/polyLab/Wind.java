package com.ait.polyLab;

public class Wind implements IInstrument{

	@Override
	public void play() {
		System.out.println("Wind.play()");
	}

	@Override
	public String what() {
		return "Wind";
	}

	@Override
	public void adjust() {
		System.out.println("Wind.adjust()");
	}

}

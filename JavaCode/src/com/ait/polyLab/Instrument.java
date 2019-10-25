package com.ait.polyLab;

abstract public class Instrument {
	public void play() {
		System.out.println("Instrument.play()");
	}
	public String what() {
		return "Instrument";
	}
	public void adjust() {
		System.out.println("Wind.adjust()");
	}
	
}

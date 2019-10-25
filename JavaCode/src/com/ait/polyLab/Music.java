package com.ait.polyLab;

public class Music {

	public static void tune(IInstrument i ) {
		i.play();
	}
	public static void tuneAll(IInstrument[] e) {
		
		/*
		 * for (int i = 0; i < e.length; i++) { tune(e[i]); }
		 */
		for (IInstrument instrument : e) {
			tune(instrument);
		}
	}
	public static void main(String[] args) {
		IInstrument [] orchestra = new IInstrument[5];
		
		orchestra[0] = new Wind();
		orchestra[1] = new Percussion();
		orchestra[2] = new Stringed();
		orchestra[3] = new Brass();
		orchestra[4] = new Woodwind();
		
		/*
		 * for(int i = 0; i < orchestra.length; i++) { orchestra[i] = new Instrument();
		 * }
		 */
		 
		
		tuneAll(orchestra);

	}

}

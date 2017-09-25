package calculator;

import javax.swing.JFrame;

public class driver {

	public static void main(String[] args) 
	{
		JFrame frame = new calculator("Calculator");
		frame.setSize(400,500);
		//frame.pack(); //sets the exact size so all the buttons can fir in
		frame.setLocation(300, 300);// sets where calculator will appear on the screen 
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
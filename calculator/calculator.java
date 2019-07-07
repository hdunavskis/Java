package calculator;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;// not sure if needed 
import java.util.regex.Matcher;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
/**
 * 
 * @author helmuts
 * @version 1.0
 *
 */
public class calculator extends JFrame
{
		private JButton button = new JButton();
		private Font font;// variable for font
		private JTextField text = new JTextField();
		private Font buttonFont;
		
	/**
	 * 
	 * @param title - extends from JFrame class
	 * 
	 */
public calculator(String title)
	{
		super(title);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes window
		font = new Font("Lucida Conslole", Font.PLAIN,50);//change the size of the font
		text.setFont(font);
		buttonFont = new Font("Arial", Font.BOLD,20);
		text.setEditable(false); // can not enter anything from keyboard
		text.setText("0"); // default value
		text.setHorizontalAlignment(SwingConstants.RIGHT);// sets numbers to right 
		
		setLayout(new BorderLayout(10,10));//layout for frame
		JPanel buttonPanel = new JPanel ();
		buttonPanel.setLayout(new GridLayout(6,4,10,10));// layout for panel
	
		ButtonListener listener = new ButtonListener();
		
		button = new JButton("MS" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		button = new JButton("MS+" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
	
		button = new JButton("MS-" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		
		button = new JButton("MC" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		button = new JButton("Ce" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);

		button = new JButton("\u2190" + "");// backspace
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		button = new JButton("\u221A"+ "");// square root
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		button = new JButton("%"+ "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		// Organizes buttons
		for(int i = 7; i < 10; i++)
			{
				button = new JButton(i + "");
				button.setFont(buttonFont);
				buttonPanel.add(button);
				button.addActionListener(listener);
			}
		
		button = new JButton("/"+ "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		for(int i = 4; i < 7; i++)
			{
				button = new JButton(i + "");
				button.setFont(buttonFont);
				buttonPanel.add(button);
				button.addActionListener(listener);
			}
		button = new JButton("*" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		for(int i = 1; i < 4; i++)
			{
				button = new JButton(i + "");
				button.setFont(buttonFont);
				buttonPanel.add(button);
				button.addActionListener(listener);
			}
		
		button = new JButton("+" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		button = new JButton("0" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
			
		button = new JButton("." + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
			
		button = new JButton("=" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
			
		button = new JButton("-" + "");
		button.setFont(buttonFont);
		buttonPanel.add(button);
		button.addActionListener(listener);
		
		add("Center", buttonPanel);
		add("North", text);
	}	

private class ButtonListener implements ActionListener 
	{
		String storedValue=""; // stored value for memory button
		boolean reset = false; //sets text field to "" after "=" button
		
	public void actionPerformed(ActionEvent e)
		{//ScriptEngineManager does all the calculations
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			
			String ButtonLabel = e.getActionCommand();
			
//numeric buttons		
			if(ButtonLabel.equals("9") && text.getText().equals("0"))
				{
					text.setText("9");
					reset = false;
				}
			
			else if (ButtonLabel.equals("9")&& reset == true)
				{
					text.setText("");
					text.setText("9");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("9"))
				text.setText(text.getText()+"9");
			
			if(ButtonLabel.equals("8") && text.getText().equals("0"))
				{
					text.setText("8");
					reset = false;
				}
			
			else if (ButtonLabel.equals("8")&& reset == true)
				{
					text.setText("");
					text.setText("8");
					reset =false;
				}	
			
			else if(ButtonLabel.equals("8"))
				text.setText(text.getText() + "8");
			
			if(ButtonLabel.equals("7") && text.getText().equals("0"))
				{
					text.setText("7");
					reset = false;
				}
			
			else if (ButtonLabel.equals("7")&& reset == true)
				{
					text.setText("");
					text.setText("7");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("7"))
				text.setText(text.getText() + "7");
			
			if(ButtonLabel.equals("6") && text.getText().equals("0"))
				{
					text.setText("6");
					reset = false;
				}
			
			else if (ButtonLabel.equals("6")&& reset == true)
				{
					text.setText("");
					text.setText("6");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("6"))
					text.setText(text.getText() + "6");
				
			if(ButtonLabel.equals("5") && text.getText().equals("0"))
				{
					text.setText("5");
					reset = false;
				}
			
			else if (ButtonLabel.equals("5")&& reset == true)
				{
					text.setText("");
					text.setText("5");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("5"))
					text.setText(text.getText() + "5");
				
			if(ButtonLabel.equals("4") && text.getText().equals("0"))
				{
					text.setText("4");
					reset = false;
				}
			
			else if (ButtonLabel.equals("4")&& reset == true)
				{
					text.setText("");
					text.setText("4");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("4"))
					text.setText(text.getText() + "4");
				
			if(ButtonLabel.equals("3") && text.getText().equals("0"))
				{
					text.setText("3");
					reset = false;
				}
			
			else if (ButtonLabel.equals("3")&&reset == true)
				{
					text.setText("");
					text.setText("3");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("3"))
					text.setText(text.getText() + "3");
				
			if(ButtonLabel.equals("2") && text.getText().equals("0"))
				{
					text.setText("2");
					reset = false;
				}	
			
			else if (ButtonLabel.equals("2")&& reset == true)
				{
					text.setText("");
					text.setText("2");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("2"))
					text.setText(text.getText() + "2");
				
			if(ButtonLabel.equals("1") && text.getText().equals("0"))
				{
					text.setText("1");
					reset = false;
				}	
			
			else if (ButtonLabel.equals("1")&& reset == true)
				{
					text.setText("");
					text.setText("1");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("1"))
					text.setText(text.getText() + "1");
				
			if(ButtonLabel.equals("0") && text.getText().equals("0"))
				{
					text.getText();
					reset = false;
				}
				
			else if (ButtonLabel.equals("0")&& reset == true)
				{
					text.setText("");
					text.setText("0");
					reset =false;
				}	
			
			else if (ButtonLabel.equals("0"))
					text.setText(text.getText() + "0");
//+ button			
			if(ButtonLabel.equals("+") && text.getText().equals("0"))	
				{
					reset = false;
					text.setText(text.getText()+"+");
				}
			
			else if (ButtonLabel.equals("+") && !lastOperator(text.getText()))//checks if last character is an operator
					text.setText(text.getText().substring(0, text.getText().length()-1) + "+");// replaces last char to +
			
			else if (ButtonLabel.equals("+") && !lastOperator(text.getText()))
					text.getText();
			
			else if (ButtonLabel.equals("+") && text.getText().equals(""))
				{
					reset = false;
					text.setText("0+");
				}
			else if(ButtonLabel.equals("+"))
				{
					reset = false;
					text.setText(text.getText() + "+");
				}
// - button			
			if(ButtonLabel.equals("-") && text.getText().equals("0"))
				{
					reset = false;
					text.setText(text.getText()+"-");
				}
			
			else if(ButtonLabel.equals("-") && !lastOperator(text.getText()))
					text.setText(text.getText().substring(0, text.getText().length()-1) + "-");// replaces last char to -
			
			else if (ButtonLabel.equals("-") && !lastOperator(text.getText()))
					text.getText();
			
			else if (ButtonLabel.equals("-") && text.getText().equals(""))
				{
					reset = false;
					text.setText("0-");
				}
			
			else if (ButtonLabel.equals("-"))
				{
					reset = false;
					text.setText(text.getText() + "-");
				}
// * button			
			if(ButtonLabel.equals("*") && text.getText().equals("0"))
				{
					reset = false;
					text.setText(text.getText()+"*");
				}
			
			else if(ButtonLabel.equals("*") && !lastOperator(text.getText()))
				text.setText(text.getText().substring(0, text.getText().length()-1) + "*");// replaces last char to *
			
			else if (ButtonLabel.equals("*") && !lastOperator(text.getText()))
				text.getText();
			
			else if (ButtonLabel.equals("*") && text.getText().equals(""))
				{
					reset = false;
					text.setText("0*");
				}
			
			else if (ButtonLabel.equals("*"))
				{
					reset=false;
					text.setText(text.getText() + "*");
				}
// / button			
			if(ButtonLabel.equals("/") && text.getText().equals("0"))
				{
					reset = false;
					text.setText(text.getText()+"/");
				}
			
			else if(ButtonLabel.equals("/") && !lastOperator(text.getText()))
				text.setText(text.getText().substring(0, text.getText().length()-1) + "/");// replaces last char to /
			
			else if (ButtonLabel.equals("/") && !lastOperator(text.getText()))
				text.getText();
			
			else if (ButtonLabel.equals("/") && text.getText().equals(""))
				{
					reset = false;
					text.setText("0/");
				}
			
			else if (ButtonLabel.equals("/"))
				{
					reset = false;
					text.setText(text.getText() + "/");
				}
//MS button
			if(ButtonLabel.equals("MS"))// memory store 
				{//does not allow to store number with operators
					if(text.getText().matches(".*[-+/*].*")|| text.getText().equals("0"))
						{
							if(text.getText().startsWith("-"))
								{//stores negative value
									storedValue = text.getText();
								}
						}
					else
						{
							storedValue = text.getText();
						}
				}
// MS- button		
			if(ButtonLabel.equals("MS-"))//subtract value from memory
				{
					if(text.getText().matches(".*[-+/*].*"))
							{
								text.getText();
							}
					else if(text.getText().compareTo("0") > 0 && storedValue.compareTo("") > 0)//returns 0 if both strings are equal
						{
							if(storedValue.startsWith("-"))
								text.setText(text.getText()+"-("+storedValue+")");	
							else
								text.setText(text.getText()+"-"+storedValue);	
						}	
				}
//MS+ button			
			if(ButtonLabel.equals("MS+"))//add stored value
				{
						if(text.getText().matches(".*[-+/*].*"))// if string contains any of the characters in []
							{
								text.getText();
							}
						
						else if(text.getText().compareTo("0") > 0 && storedValue.compareTo("") > 0)//returns 0 if both strings are equal
							{
								if(storedValue.startsWith("-"))
									text.setText(text.getText()+"+("+storedValue+")");	
								else
									text.setText(text.getText()+"+"+storedValue);	
							}
				}
//MC button
			if(ButtonLabel.equals("MC"))// clears the memory
				storedValue="";
// = button			
			if(ButtonLabel.equals("=") && text.getText().equals("0"))
				text.getText();
			
			else if(ButtonLabel.equals("="))
			{
				if(divideBy(text.getText()))
					text.setText("Dividing by 0");
								
				else if(!lastOperator(text.getText()))
					{
						text.setText(text.getText().substring(0, text.getText().length()-1));//ignores operand if there is any
						String storeObject; //temporary store object value
						double cast; // variable to cast string to double needed to use Math.round(). Cannot cast object to double
						
						try 
							{
								Object result = engine.eval(text.getText());
								
								storeObject = String.valueOf(result);
								cast = Double.parseDouble(storeObject);
								cast = (double)Math.round(cast * 100000d)/100000d;// rounds to 5decimal places
								
								if(cast == (long) cast)
									{
										text.setText(String.format("%d", (long) cast));//does not print decimal 0
										reset = true;
									}
								else
									{
										text.setText(String.valueOf(cast));
										reset = true;
									}
							} 
						catch (ScriptException e1) 
							{
								text.setText("Error");
							}
					}	
				
				else if(!text.getText().equals(""))
					{
						String storeObject; //temporary store object value
						double cast; // variable to cast string to double needed to use Math.round()
						try 
							{
								Object result = engine.eval(text.getText());
								
								storeObject = String.valueOf(result);
								cast = Double.parseDouble(storeObject);
								cast = (double)Math.round(cast * 100000d)/100000d;// rounds to 5decimal places
								if(cast == (long) cast)
									{
										text.setText(String.format("%d", (long) cast));//does not print decimal 0
										reset = true;
									}
								else
									{
										text.setText(String.valueOf(cast));
										reset = true;
									}
							} 
						
						catch (ScriptException e1) 
							{
								text.setText("0");
							}
					}
			}	
// . button				
			if(ButtonLabel.equals(".") && text.getText().equals("0"))
				text.setText(text.getText() + '.');
		
			else if (ButtonLabel.equals(".")&& !lastOperator(text.getText()))
				text.getText();
			
			else if(ButtonLabel.equals(".")&& !lastOperator(text.getText()))
				text.getText();
				
			else if(ButtonLabel.equals("."))
				text.setText(decimal(text.getText()));
// Ce button			
			if(ButtonLabel.equals("Ce"))// resets memory and text field
				{
					text.setText("0");
					reset = false;
				}	
// square root			
			if(ButtonLabel.equals("\u221A")&& text.getText().equals("0"))// square root
				text.getText();
			
			else if(ButtonLabel.equals("\u221A"))// square root
						text.setText(src(text.getText())); // calls method src(square root)
				
//% button	
			if(ButtonLabel.equals("%")&&text.getText().equals("0"))
				text.setText(text.getText());
			
			else if(ButtonLabel.equals("%"))
					text.setText(percent(text.getText()));
// backspace button			
			if(ButtonLabel.equals("\u2190")&& text.getText().equals("0"))// backspace
				text.getText();
			
			else if(ButtonLabel.equals("\u2190") && text.getText().equals("")) // backspace
				text.setText("0");
			
			else if(ButtonLabel.equals("\u2190")) // backspace
				text.setText(text.getText().substring(0,text.getText().length()-1));
		}
	}
// methods
/**
 * 
 * @param x - Takes in String as an argument. Divides String in two parts and stores values in the 2 arrays. Calculates percentage
 * @return - returns String .
 */
public String percent(String x)// calculate percentage
	{
		String empty="0";//default returning value 
		
		if(x.matches(".*[-+/*].*"))// if string contains any of those characters then split the string in there
			{
				String []divide = x.split("[-+/*]"); 
				String []parts = new String[2];
				
				parts[0] = divide[0];// store first part of string after splitting
				parts[1] = divide[1];// second part of string after splitting
					
				double firstPart; 
				double secondPart;
				double percentage;
				String result;
				
				firstPart = Double.parseDouble(parts[0]); // first part of string from splitting
				secondPart = Double.parseDouble(parts[1]);// second part of string from splitting
				percentage = (firstPart * secondPart)/100; // calculates percentage
				result = String.valueOf(percentage);
				return result;
			}
		return empty;
	}
/**
 * 
 * @param root - Takes String as an argument. Calculates square root
 * @return - returns String.
 */
public String src (String root)//calculate the square root
	{
		double sqr = Double.parseDouble(root);
		
		sqr = Math.sqrt(sqr);
		double any = (double)Math.round(sqr * 100000d) / 100000d;// limit of 5decimal places
		if(any == (long) any)
			return String.format("%d", (long)any); // returns integer if no decimal
		
		return String.valueOf(any);
	}
/**
 * 
 * @param d - Takes in String as an argument. Allows only one decimal place
 * @return - returns String
 */
public String decimal(String d)// does not allow to enter more than one decimal point.
	{	
		int i;
		
		if(d.matches(".*[-+/*].*"))// if string contains any of those characters
			{
				for(i = d.length()-1; i >= 0; i--)
					{
						if(d.charAt(i)=='+'||d.charAt(i)=='-'|| d.charAt(i)=='/'|| d.charAt(i)=='*')
							{
								String sub;
								sub = d.substring(i, d.length()-1);
									if(sub.contains("."))
										{
											return d;
										}
									else
										{
											return d+".";
										}
							}
					}
			}
		
		 if(d.contains("."))
				{
					return d;
				}
			return d + ".";
	}
/**
 * 
 * @param last - Takes in String as an argument. Checks if the last character is an operator
 * @return - returns boolean.
 */
public boolean lastOperator(String last)// checks if last character is operator or decimal point
	{
		if(last.endsWith("-")||last.endsWith("+")||last.endsWith("/")||last.endsWith("*")||last.endsWith("."))
			{
				return false;
			}
		return true;
	}
/**
 * 
 * @param div Takes in String as an argument. Does not allow to divide by 0
 * @return Returns boolean
 */
public boolean divideBy(String div)//does not allow divide by 0
	{//checks if string contains any of following 
		CharSequence seq1 = "/0-";
		CharSequence seq2 = "/0+";
		CharSequence seq3 = "/0/";
		CharSequence seq4 = "/0*";
	
		boolean seqCheck1 = text.getText().contains(seq1);
		boolean seqCheck2 = text.getText().contains(seq2);
		boolean seqCheck3 = text.getText().contains(seq3);
		boolean seqCheck4 = text.getText().contains(seq4);
		
		if(seqCheck1||seqCheck2||seqCheck3||seqCheck4 || div.endsWith("/0") || div.endsWith("/0."))
			{
				return true;
			}
		return false;
	}
}



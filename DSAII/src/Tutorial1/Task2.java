package Tutorial1;

import java.util.Scanner;

public class Task2 {


	public static String result (int a){
		
		String sum = "";
		
		
		if(a > 10){
			
			sum = "Number is greater than 10";
		} else {
			
			switch(a){
			
			case 1:
			
				sum = "One";
				break;
				
			case 2:
			
				sum = "Two";
				break;
				
			case 3:
			
				sum = "Three";
				break;
				
			case 4:
			
				sum = "Four";
				break;
				
			case 5:
				
				sum = "Five";
				break;
				
			case 6:
				
				sum = "Six";
				break;
				
			case 7:
				
				sum = "Seven";
				break;
				
			case 8:
				
				sum = "Eight";
				break;
				
			case 9:
				
				sum = "Nine";
				break;
				
			case 10:
				
				sum = "Ten";
				break;
						
			}
		}
		
		
		
		return sum; 
		
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int a =0;
		int b =0;
		char c;
		
		
		System.out.println("Enter an integer");
		
			a = input.nextInt();
		
		System.out.println(result(a));
	}
}

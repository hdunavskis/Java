package Tutorial1;

import java.util.Scanner;

public class Task4 {

	public static int factorial (int a){
		
		int i;
		int result = 1;
		for(i = 1; i <= a; i++){
			
			result = result * i;
			
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		int number;
		
		
		System.out.println("Enter integer");
		number = input.nextInt();
		
		System.out.println("Factorial of number entered is " + factorial(number));
		

	}

}

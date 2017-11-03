package Tutorial1;

import java.util.Scanner;

public class Task1 {

	 public static int larger(int a, int b) {
		   /* Returns the larger of two ints passed as arguments
		    */
		    if (a > b) {
		      return a;
		    } else {
		      return b;
		    }
		  }


	public static void main(String[] args) {
		//in is a variable
		Scanner input = new Scanner(System.in);
		
			    int a, b;
			    a = 5;
			    b = 6;
			    System.out.print("The larger of " + a + " and ");
			    System.out.println(b + " is " + larger(a, b) + '.');
			  
	
	}

}

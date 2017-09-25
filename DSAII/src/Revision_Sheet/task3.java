package Revision_Sheet;

import java.util.Scanner;
public class task3 {

	public static int largest (int a[]){
		
		int i, biggest = a[0];
		
		
		for(i =1; i < a.length;i++){
			
			if(a[i] > biggest){
				
				biggest = a[i];
			}
			
		}
		
		return biggest;
	}
	
	public static void main(String[] args) {
	
		
		Scanner input = new Scanner(System.in);

		int[] array = new int[25];
		int i;
		
		for(i = 0; i < array.length; i++){
			
			System.out.println("Please enter integer");
			array[i] = input.nextInt();
			
		}
		
		System.out.println("Biggest number entered is " + largest(array));
		
		
	}

}

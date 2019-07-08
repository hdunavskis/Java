import java.util.InputMismatchException;
import java.util.Scanner;

public class SwitchExercise {

	
	public static void switchOnAString() {
		Scanner sc = new Scanner(System.in);
		String name = "";
		String gender ="";
		
		try {
			System.out.println("Enter a name: ");
			name = sc.next();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong input!");
			System.exit(1);
		}
		
		switch(name.toUpperCase()) {
		case "JOHN":
			gender = "Male";
			break;
		case "MARY":
			gender = "Female";
			break;
		default:
			System.out.println("Wrong name!");
		}
	System.out.println(gender);	
	}
	
	public static void switchMonth() {
		Scanner sc = new Scanner(System.in);
		int month = 0;
		String result = "";
		
		try {
			System.out.println("Enter month: ");
			month = sc.nextInt();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Only number 1-12!");
			System.exit(1);
		}
		
		switch(month){
		case 1:
			result = "January";
			break;
		case 2:
			result = "February";
			break;
		case 3:
			result = "March";
			break;
		case 4:
			result = "April";;
			break;
		case 5:
			result = "May";
			break;
		case 6:
			result = "June";
			break;
		case 7:
			result = "July";
			break;
		case 8:
			result = "August";
			break;
		case 9:
			result = "September";
			break;
		case 10:
			result = "October";
			break;	
		case 11:
			result = "November";
			break;
		case 12:
			result = "December";
			break;
		default:
			System.out.println("Invalid month: " + month);
		}
		
		System.out.println(result);
	}
	public static void switchChar(double num1, double num2, char operator) {
		
		double result =0;
		
		switch(operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		default:
			System.out.println("Wrong characters!");
		}
		System.out.println(result);
	}
	public static void switchSquareOrCube() {
		Scanner sc = new Scanner(System.in);
		double number = 0;
		double result = 0;
		
		try {
			System.out.println("Enter a number: ");
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Only numbers 1-10!");
			System.exit(1);
		}
		switch((int)number % 2) {
		case 0:
			result = Math.pow(number, 2);
			break;
		case 1:
			result = Math.pow(number, 3);
			break;
		default:
			System.out.println("Default message!");
		}
		System.out.println(result);
		
	}
	public static void switchVowelOrConstant() {
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		String letter = "";
		
		try {
			System.out.println("Enter a char: ");
			ch = sc.next().charAt(0);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Only letters!");
			System.exit(1);
		}
		
		switch(Character.toLowerCase(ch)) {
		case 'a':
			letter = "vowel";
			break;
		case 'e':
			letter = "vowel";
			break;
		case 'i':
			letter = "vowel";
			break;
		case 'o':
			letter = "vowel";
			break;
		case 'u':
			letter = "vowel";
			break;
		default:
			letter = "consonant";
			
		}
		System.out.println(ch + " is a " + letter);
	}
	public static void switchDaysInMonth(int year, int month) {
		Scanner sc = new Scanner(System.in);
		
		int numberOfDays = 31;
		boolean leap = false;
		
		if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)) {
			leap = true;
		}
	     
		switch(month) {
		case 2:
			numberOfDays = leap ? 29 : 28; 
			break;
		case 4:
			numberOfDays = 30;
			break;
		case 6:
			numberOfDays = 30;
			break;
		case 9:
			numberOfDays = 30;
			break;
		case 11:
			numberOfDays = 30;
			break;
		}
		System.out.println("Number of days: " + numberOfDays);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int month = 0;
		int year = 0;
		double num1 =0;
		double num2 =0;
		char op = ' ';
		//switchOnAString();
		//switchMonth();
		/*
		 * try { System.out.println("Enter number 1: "); num1 = sc.nextDouble();
		 * System.out.println("Enter nnumber 2: "); num2 = sc.nextDouble();
		 * System.out.println("Enter a char: "); op = sc.next().charAt(0);
		 * switchChar(num1, num2, op);
		 * 
		 * } catch (InputMismatchException e) { // TODO Auto-generated catch block
		 * System.out.println("Wrong char!"); System.exit(1); }
		 */
		//switchSquareOrCube();
		//switchVowelOrConstant();
		try {
			System.out.println("Enter year: ");
			year = sc.nextInt();
			System.out.println("Enter month (1..12): ");
			month = sc.nextInt();
			switchDaysInMonth(year, month);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Only letters!");
			System.exit(1);
		}
	}

}

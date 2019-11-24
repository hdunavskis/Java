package com.ait.practice;

import java.util.Scanner;

import com.ait.practice.BookStore.BookImpl;

public class CodeAssesment2 {

	static Scanner sc = new Scanner(System.in);
	
	
	public static int userChoice() {

		String menu = "1. String Builder\n";
		menu += "2. Exceptions\n";
		menu += "3. Inner Classes\n";
		menu += "4. Enummerations\n";
		menu += "99. Exit\n";
		System.out.println("What do you want to do?");
		System.out.println(menu);
		
		int i = sc.nextInt();
		return i;
	}

	public static void innerClasses() {
		BookStore bs = new BookStore();
		BookImpl b = (BookImpl)bs.getABook("Java Programming", "Joel Murach", true, 5);
		System.out.println("Number of languages is: " + b.howManyLanguages());
		System.out.println("Is it a best seller? : " + b.isBestSeller());
	}
	public static void method1() {
		method2();
	}
	public static void method2() {
		try {
			method3();
		} catch (TestException e) {
			
			e.printStackTrace();
		}
	}
	public static void method3() throws TestException {
		throw new TestException("An I/O exception occured\n");
	}
	public static void stringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("GO PLACIDLY amid the noise and the haste, and remember what peace there\n "
				+ "may be in silence. As far as possible, without surrender, be on good terms\n "
				+ "with all persons. Speak your truth quietly and clearly; and listen to others,\n "
				+ "even to the dull and the ignorant; they too have their story. Avoid loud and \n"
				+ "aggressive persons; they are vexatious to the spirit. \n"
				+ "If you compare yourself with others, you may become vain or bitter, for\n "
				+ "always there will be greater and lesser persons than yourself. Enjoy your\n "
				+ "achievements as well as your plans. Keep interested in your own career,\n "
				+ "however humble; it is a real possession in the changing fortunes of time.\n");
		
		sb.insert(sb.indexOf("GO"), "1.");
		sb.insert(sb.indexOf("may"), "2.");
		sb.insert(sb.indexOf("with all persons"), "3.");
		sb.insert(sb.indexOf("even"), "4.");
		sb.insert(sb.indexOf("aggressive"), "5.");
		sb.insert(sb.indexOf("If"), "6.");
		sb.insert(sb.indexOf("always"), "7.");
		sb.insert(sb.indexOf("achievements"), "8.");
		sb.insert(sb.indexOf("however"), "9.");
		
		sb.setCharAt(sb.indexOf("however humble") + "however humble".length(), ':');
		sb.deleteCharAt(sb.indexOf("surrender")+2);
		sb.deleteCharAt(sb.indexOf("aggressive")+5);
		
		int start = sb.indexOf("remember what");
		int end = start + "remember what peace there may be in silence".length();
		System.out.println(sb);
		String s = sb.substring(start, end);
		
		s = s.replace("2.", "");
		s = s.replace("\n", "");
		System.out.println(s);
	}
	public static void enums() {
		Lecturer joeBlogs = Lecturer.Al;
		joeBlogs.setMasters(true);
		joeBlogs.setYears(5);
		System.out.println(joeBlogs.toString());
		System.out.println("Is this lecturer eligivle for progression? : " + isProgrssion(joeBlogs));
	}

	
	public static boolean isProgrssion(Lecturer l) {
	  
		if(l == Lecturer.Al) {
			if((l.hasMasters() && l.getYearsService() > 4) || (l.hasPhd() && l.getYearsService() > 2)) {
				return true;
			}
		}else if(l == Lecturer.L) {
			if(l.getYearsService() > 19) {
				return true;
			}
		}
		return false;
	}
	 
	public static void main(String[] args) {
		
		int index = userChoice();
		
		while (index != 99) {
			
			switch (index) {
			case 1:
				stringBuilder();
				break;
			case 2:
				method1();
				break;
			case 3:
				innerClasses();
				break;
			case 4:
				enums();
				break;

			default:
				System.out.println("Unknown entry");
				break;
			}
			index = userChoice();
		}
		System.out.println("Exiting...");
	}

}

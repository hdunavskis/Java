package com.ait.game;
import java.util.Scanner;
public class IO {
	private String name1;
	private String name2;
	private static Scanner sc = new Scanner(System.in);
	
	
	public void welcome() {
		System.out.println("Welcome to the Dice Roller application");
		System.out.println();
		System.out.println("Please enter player one name: ");
		this.name1 = sc.next();
		System.out.println("Please enter player two name: ");
		this.name2 = sc.next();
	}
	
	public String getPlayerName1() {
		return this.name1;
	}
	
	public String getPlayerName2() {
		return this.name2;
	}
	public String roll() {
		System.out.println("Roll the dice? (y/n): ");
		return sc.next().toLowerCase();
	}
	public void returnDraw() {
		System.out.println("Draw");
	}
	public void playerWins(Player p) {
		System.out.println(p.getName() + " wins!");
	}
}

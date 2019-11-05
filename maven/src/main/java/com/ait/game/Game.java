package com.ait.game;
import com.ait.game.Player;

public class Game {

	private int numDiceRolls;
	static final int SCORE_TO_WIN = 20;
	
	public void start(Die dice, IO io, Player player1, Player player2) {
		
		numDiceRolls = 1;
		String choice = io.roll();
		while (choice.equals("y")) {
			
			System.out.println("");
			System.out.println("Round " + numDiceRolls + ": ");
			System.out.println("Rolling dice for player one ");
			dice.roll();
			System.out.println("Die 1 is " + dice.getValue1());
			System.out.println("Die 2 is " + dice.getValue2());
			player1.setTotalScore(dice.getSum(player1));
			System.out.println("Rolling dice for player two ");
			dice.roll();
			System.out.println("Die 1 is " + dice.getValue1());
			System.out.println("Die 2 is " + dice.getValue2());
			player2.setTotalScore(dice.getSum(player2));
			System.out.println(player1.toString());
			System.out.println(player2.toString());
			choice = "n";
			if ((player1.getTotalScore() > SCORE_TO_WIN) && (player2.getTotalScore() >= SCORE_TO_WIN)) {
				io.returnDraw();
			} else if (player1.getTotalScore() >= SCORE_TO_WIN) {
				io.playerWins(player1);
			} else if (player2.getTotalScore() >= SCORE_TO_WIN) {
				io.playerWins(player2);
			} else {
				choice = io.roll();
				System.out.println("No winner yet");
			}
			numDiceRolls++;
		}
		System.out.println("Good bye!");
	}
}

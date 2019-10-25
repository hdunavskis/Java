package com.ait.game;

public class DiceRollerApp
{
	
    public static void main(String args[])
    {
        Game game=new Game();
       // PairOfDice die = new PairOfDice();
        Die die = new Die();
        IO io = new IO();
        io.welcome();
        Player p1 = new Player(io.getPlayerName1());
        Player p2 = new Player(io.getPlayerName2());
        
    	game.start(die, io, p1, p2);
	}
} 
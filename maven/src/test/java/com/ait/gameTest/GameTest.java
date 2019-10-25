package com.ait.gameTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import static org.mockito.Mockito.*;

import com.ait.game.Die;
import com.ait.game.Game;
import com.ait.game.IO;
import com.ait.game.PairOfDice;
import com.ait.game.Player;

public class GameTest {
	private Game game;
	private Player pl1;
	private Player pl2;
	//private PairOfDice pd;
	private Die pd;
	private IO io;
	
	@BeforeEach
	void setUp() {
		game = new Game();
		pl1 = new Player("first");
		pl2 = new Player("second");
		//pd = mock(PairOfDice.class);
		pd = mock(Die.class);
		io = mock(IO.class);
	}
	
	@Test
	void drawTest() {
		when(io.roll()).thenReturn("y");
		when(pd.getSum(pl1)).thenReturn(22);
		when(pd.getSum(pl2)).thenReturn(22);
		pl1.setTotalScore(pd.getSum(pl1));
		pl2.setTotalScore(pd.getSum(pl2));
		game.start(pd, io, pl1, pl2);
		verify(io, new Times(1)).returnDraw();	
		verify(io, new Times(0)).playerWins(pl1);	
		verify(io, new Times(0)).playerWins(pl2);;	
	}
	@Test
	void playerOneWinsTest() {
		when(io.roll()).thenReturn("y");
		when(pd.getSum(pl1)).thenReturn(22);
		when(pd.getSum(pl2)).thenReturn(5);
		pl1.setTotalScore(pd.getSum(pl1));
		pl2.setTotalScore(pd.getSum(pl2));
		game.start(pd, io, pl1, pl2);
		verify(io, new Times(0)).returnDraw();	
		verify(io, new Times(1)).playerWins(pl1);	
		verify(io, new Times(0)).playerWins(pl2);	
	}
	@Test
	void playerTwoWinsTest() {
		when(io.roll()).thenReturn("y");
		when(pd.getSum(pl1)).thenReturn(5);
		when(pd.getSum(pl2)).thenReturn(22);
		pl1.setTotalScore(pd.getSum(pl1));
		pl2.setTotalScore(pd.getSum(pl2));
		game.start(pd, io, pl1, pl2);
		verify(io, new Times(0)).returnDraw();	
		verify(io, new Times(0)).playerWins(pl1);	
		verify(io, new Times(1)).playerWins(pl2);
	}
	@Test
	void noWinnersTest() {
		when(io.roll()).thenReturn("y");
		when(pd.getSum(pl1)).thenReturn(5);
		when(pd.getSum(pl2)).thenReturn(5);
		pl1.setTotalScore(pd.getSum(pl1));
		pl2.setTotalScore(pd.getSum(pl2));
		game.start(pd, io, pl1, pl2);
		verify(io, new Times(0)).returnDraw();	
		verify(io, new Times(0)).playerWins(pl1);	
		verify(io, new Times(0)).playerWins(pl2);
	}
}

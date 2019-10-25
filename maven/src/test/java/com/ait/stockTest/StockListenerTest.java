package com.ait.stockTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.stock.Stock;
import com.ait.stock.StockBroker;
import com.ait.stock.StockListener;

class StockListenerTest {
	
	private StockListener sl;
	private StockBroker sb; 
	private Stock stock; 

	
	@BeforeEach
	void setup() {
		sb = mock(StockBroker.class);
		sl = new StockListener(sb);
		stock= new Stock("1", 100.0);
		
	}
	
	@Test
	public void sellStocksWhenPriceGoesUp() {
		
		when(sb.getQoute(stock)).thenReturn(190.0);
		sl.takeAction(stock);
		verify(sb).sell(stock, 10);
	}
	@Test
	public void buyStocksWhenPriceGoesUpEquals() {
		
		when(sb.getQoute(stock)).thenReturn(100.0);
		sl.takeAction(stock);
		verify(sb).buy(stock, 100);
	}
	
	@Test
	public void buyStocksWhenPriceGoesDown() {
		
		when(sb.getQoute(stock)).thenReturn(90.0);
		sl.takeAction(stock);
		verify(sb).buy(stock, 100);
	}

}

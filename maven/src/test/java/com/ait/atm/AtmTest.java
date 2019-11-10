package com.ait.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.internal.verification.Times;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.atm.control.Account;
import com.ait.atm.control.AtmController;
import com.ait.atm.io.AtmInterface;
import com.ait.boundaries.AccountDAO;
import com.ait.boundaries.NotificationService;
import com.ait.exception2.ATMException;

class AtmTest {
	private final double AMOUNT = 20.0;
	private AtmInterface atm;
	private Account acc;
	private AtmController atmc;
	private AccountDAO ado;
	private NotificationService ns;

	@BeforeEach
	void setUp() {
		ado = mock(AccountDAO.class);
		ns = mock(NotificationService.class);
		atm = mock(AtmInterface.class);
		acc = new Account("acc", "123", "1234", 100.0);
		atmc = new AtmController(atm, ado, ns);
	}
	@Test
	void testWithDrawMoneySuccess() throws ATMException{
	
		//doNothing().when(atm).dispenseMoney(AMOUNT);
		
		atmc.withDrawAmount(AMOUNT);		
	
		assertNotNull(atmc);
		//verify(atm, new Times(1)).dispenseMoney(AMOUNT);
		//verify(atm, new Times(1)).printMsg("Please take your money");
		//verify(atm, new Times(1)).printReceipt("Receipt for 20.0 euro");
	}

}

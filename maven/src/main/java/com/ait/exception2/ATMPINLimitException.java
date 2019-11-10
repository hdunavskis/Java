package com.ait.exception2;

public class ATMPINLimitException extends ATMException {

	private static final long serialVersionUID = 334051992916748022L;

	public ATMPINLimitException() {
		super("Maximum incorrect PIN limit");
	}

}

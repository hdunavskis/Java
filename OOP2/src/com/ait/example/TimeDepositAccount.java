package com.ait.example;

import java.util.Date;

public class  TimeDepositAccount extends Account{

    private final Date maturityDate;

    public TimeDepositAccount(double balance, final Date maturityDate){
        super(balance);
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString(){
        return null;
    }

    @Override
    public boolean withdraw() {
        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

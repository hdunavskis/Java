package com.ait.example;

public abstract class Account {
    protected double balance;

    public Account(double balance){
        this.balance = balance;
    }
    public abstract boolean withdraw();
    public abstract String getDescription();
    public double getBalance() {
        return balance;
    }
}

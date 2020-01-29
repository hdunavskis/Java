package com.ait.example;

public class Customer {
    private String firstName;
    private String lastName;
    private Account [] accounts;
    private int numbeOfAccounts;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void addAccount(Account timeDepositAccount){

    }
    public int getNumbeOfAccounts(){
        return this.numbeOfAccounts;
    }
    public  Account getAccounts(int i){
        TimeDepositAccount timeDepositAccount = null;
        return timeDepositAccount;
    }
}

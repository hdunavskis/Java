package com.ait.example;

public class Customer {
    private String firstName;
    private String lastName;
    private Account [] accounts = new Account[20];
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
    public void addAccount(Account account){
    	
		accounts[numbeOfAccounts] = account;
		numbeOfAccounts++;
    	
    }
    public int getNumbeOfAccounts(){
        return this.numbeOfAccounts;
    }
    public  Account getAccounts(int i){
        
        return accounts[i];
    }
}

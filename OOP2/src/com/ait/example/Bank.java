package com.ait.example;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank(){};

    public void addCustomer(String firstName, String lastName){
        customers[numberOfCustomers] = new Customer(firstName, lastName);
        numberOfCustomers++;

    }
    public int getNumberOfCustomers(){
        return this.numberOfCustomers;
    }
    public Customer getCustomer(int index){

        return customers[index];
    }

}

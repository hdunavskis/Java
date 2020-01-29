package com.ait.example;

import java.util.Calendar;

public class AbstractBankingMain {
    private static void initializeCustomers(Bank bank){
        Customer customer;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 180);

        bank.addCustomer("Jane", "Simms");
        bank.addCustomer("Owen", "Bryant");
        bank.addCustomer("Tim", "Soley");
        bank.addCustomer("Maria", "Soley");

        customer = bank.getCustomer(0);
        customer.addAccount(new TimeDepositAccount(500.00, calendar.getTime()));
        customer = bank.getCustomer(2);
        customer.addAccount(new TimeDepositAccount(1500.00, calendar.getTime()));
        customer = bank.getCustomer(3);
        customer.addAccount(new TimeDepositAccount(150.00, calendar.getTime()));

    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        CustomerReport customerReport = new CustomerReport();
        customerReport.setBank(bank);
        customerReport.generateReport();
    }
}

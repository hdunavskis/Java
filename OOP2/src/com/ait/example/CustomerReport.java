package com.ait.example;

public class CustomerReport {
    private Bank bank;

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void generateReport(){
    	// Print report header
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // For each customer...
        for (int cust_idx = 0; cust_idx < bank.getNumberOfCustomers(); cust_idx++) {
            Customer customer = bank.getCustomer(cust_idx);

            // Print the customer's name
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());

            // For each TimeDepositAccount for this customer...
            for (int acct_idx = 0; acct_idx < customer.getNumbeOfAccounts(); acct_idx++) {
                Account account = customer.getAccounts(acct_idx);

                // Print the current balance of the account
                System.out.println("    " + account);
            }
        }
    }
}

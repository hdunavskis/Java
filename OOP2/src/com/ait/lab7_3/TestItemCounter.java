package com.ait.lab7_3;
//101
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestItemCounter {

    public static void main(String[] args) {
        // Current Shirt type for a transaction
        Shirt currentShirt = null;

        // Create Items to Count
        Map<String, Shirt> polos = new HashMap<>(10);
        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L"));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M"));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL"));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S"));

        // Transactions
        List<DukeTransaction> transactions = new ArrayList<>(20);
        transactions.add(DukeTransaction.createTransaction("P001", "Purchase", 30));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 5));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 4));
        // Count the shirts
        for (DukeTransaction dukeTransaction : transactions) {
			if(polos.containsKey(dukeTransaction.getProductID())) {
				currentShirt = polos.get(dukeTransaction.getProductID());
			}
			else {
				System.out.println("Wrong ID");
			}
			if(dukeTransaction.getTransactionType().equals("Purchase")) {
				currentShirt.addItems(dukeTransaction.getCount());
			}
			else if(dukeTransaction.getTransactionType().equals("Sale")) {
				currentShirt.removeItems(dukeTransaction.getCount());
			}
			else {
				System.out.println("Invalid Operation");
			}
			
		}
        
        // Convert to List
        List<Shirt> poloList = new ArrayList<>(polos.values());
        
        // Init Comparators
        Comparator sortDescription = new SortShirtByDesc();
        Comparator sortCount = new SortShirtByCount();

        // Print Results - Sort by Description

        Collections.sort(poloList, sortDescription);
        System.out.println("=== Inventory Report ===");
        
        for (Shirt shirt : poloList) {
			System.out.println(shirt.toString());
		}
     // Print Results - Sort by Count
        Collections.sort(poloList, sortCount);
        System.out.println("=== Inventory Report ===");
        
        for (Shirt shirt : poloList) {
			System.out.println(shirt.toString());
		}
    }
}

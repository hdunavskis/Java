package com.ait.lab7;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
	private Map<String, Long> productCountMap = new HashMap<String, Long>();
	private Map<String, String> productNames = new TreeMap<String, String>();
	
    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");

        ProductCounter pc = new ProductCounter(productNames);
        pc.processList(parts);
        pc.printReport();
        // Create Product Counter Object and process data
    }

    public ProductCounter(Map<String, String> productNames) {
        this.productNames = productNames;
    }

    public void processList(String[] list) {
    	
    	for(String item :list) {
    		Long itemExist = productCountMap.containsKey(item)? productCountMap.get(item):0;	
    		
    		productCountMap.put(item, itemExist + 1);
    	}
    }

    public void printReport() {
    
    	productNames.forEach((k,v)-> System.out.println("Name: " + k + "\t\tCount : " + productCountMap.get(v)));
    }
}

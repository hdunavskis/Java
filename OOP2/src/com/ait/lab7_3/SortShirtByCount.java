package com.ait.lab7_3;

import java.util.Comparator;
import java.util.TreeSet;

public class SortShirtByCount implements Comparator<Shirt> {

	
    public int compare(Shirt s1, Shirt s2) {
       
    	Long c1 = new Long(s1.getCount());
    	Long c2 = new Long(s2.getCount());
        return c1.compareTo(c2);

    }
}

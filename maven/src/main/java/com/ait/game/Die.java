package com.ait.game;
public class Die 
{
    private int value1;
    private int value2;
    private static int SIDES=6;

    public Die()
    {
       this.value1 = 1;  // initialize value to 1
       this.value2 = 1;  // initialize value to 1
    }

    // roll the die
    public void roll()
    {
        value1 = (int) (Math.random() * SIDES);  // number from 0 to sides
        value2 = (int) (Math.random() * SIDES);  // number from 0 to sides
    }
    public int getValue1()
    {
        return value1;
    }
    public int getValue2()
    {
    	return value2;
    }
    public int getSum(Player p)
    {
    	return value2 + value1;
    }
}
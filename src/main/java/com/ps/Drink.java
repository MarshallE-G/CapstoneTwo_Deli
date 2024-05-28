package com.ps;

/*
Represents a "drink"
 */

public class Drink extends Product {
    private String drinkSize;
    private String flavor;
    
    public Drink(double price, String drinkSize, String flavor) {
        super(price);
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }
    
    
    // Override calcPrice()
    
    // Getters and Setters
}

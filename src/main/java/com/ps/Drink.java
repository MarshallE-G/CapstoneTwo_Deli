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
    @Override
    public double calcPrice() {
        return 0;
    }
    
    
    // Getters and Setters
    
    public String getDrinkSize() {
        return drinkSize;
    }
    
    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }
    
    public String getFlavor() {
        return flavor;
    }
    
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}

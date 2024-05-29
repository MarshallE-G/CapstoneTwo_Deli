package com.ps;

/*
An abstract class representing the individual menu items from the deli (e.g. Sandwiches, salads, drinks, sides, etc.)
 */

public abstract class Product implements Chargeable{
    private double price;
    
    public Product() {
        this.price = 0;
    }
    
    @Override
    public abstract double calcPrice();
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

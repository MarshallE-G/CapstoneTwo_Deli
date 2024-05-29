package com.ps;

/*
An abstract class representing the individual menu items from the deli (e.g. Sandwiches, salads, drinks, sides, etc.)
 */

public abstract class Product {
    private double price;
    
    public Product(double price) {
        this.price = price;
    }
    
    public abstract double calcPrice();
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

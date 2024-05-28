package com.ps;

/*
Represents a bag of "chips"
 */

public class Chip extends Product{
    private String chipType;
    
    public Chip(double price, String chipType) {
        super(price);
        this.chipType = chipType;
    }
    
    
    // Override calcPrice()
    
    // Getters and Setters
}

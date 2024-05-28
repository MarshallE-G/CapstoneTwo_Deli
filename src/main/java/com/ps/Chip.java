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
    
    @Override
    public double calcPrice() {
        return 0;
    }
    
    
    // Getters and Setters
    
    public String getChipType() {
        return chipType;
    }
    
    public void setChipType(String chipType) {
        this.chipType = chipType;
    }
    
    
}

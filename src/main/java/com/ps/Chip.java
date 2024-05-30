package com.ps;

/*
Represents a bag of "chips"
 */

public class Chip extends Product{
    private String chipType;
    
    public Chip(String chipType) {
        super();
        this.chipType = chipType;
    }
    
    @Override
    public double calcPrice() {
        return 1.50;
    }
    
    
    public String getChipType() {
        return chipType;
    }
    
    public void setChipType(String chipType) {
        this.chipType = chipType;
    }
    
    @Override
    public String toString() {
        double price = this.calcPrice();
    
        return "\u001b[1mChips:\u001b[22m" +
                "\n" + chipType +
                "\n\u001b[3mPrice: $" + price + "\u001b[23m" +
                "\n";
    }
}

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
    
        return "Chip{" +
                "chipType='" + chipType + '\'' +
                "\nprice= $" + price +
                '}';
    }
}

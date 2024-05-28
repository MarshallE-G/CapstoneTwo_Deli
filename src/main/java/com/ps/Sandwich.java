package com.ps;

/*
Represents a "sandwich"
 */

import java.util.ArrayList;

public class Sandwich extends Product {
    private String            breadType;
    private String            sandwichSize;
    private String            meat;
    private String            cheese;
    private boolean           extraMeat;
    private boolean           extraCheese;
    private ArrayList<String> additionalToppings; // ■ Other toppings:      <--------- These are FREE!!!
    private String            sauce;
    private boolean           toasted;
    
    // Constructor
    
    public Sandwich(
            double price,
            String breadType,
            String sandwichSize,
            String meat,
            String cheese,
            boolean extraMeat,
            boolean extraCheese,
            ArrayList<String> additionalToppings,
            String sauce,
            boolean toasted
    ) {
        super(price);
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.additionalToppings = additionalToppings;
        this.sauce = sauce;
        this.toasted = toasted;
    }
    
    
    // Override calcPrice()
    
    @Override
    public double calcPrice() {
        return 0;
    }
    
    
    public String getBreadType() {
        return breadType;
    }
    
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }
    
    public String getSandwichSize() {
        return sandwichSize;
    }
    
    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }
    
    public String getMeat() {
        return meat;
    }
    
    public void setMeat(String meat) {
        this.meat = meat;
    }
    
    public String getCheese() {
        return cheese;
    }
    
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }
    
    public boolean hasExtraMeat() {
        return this.extraMeat;
    }
    
    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    
    public boolean hasExtraCheese() {
        return this.extraCheese;
    }
    
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
    
    public ArrayList<String> getAdditionalToppings() {
        return additionalToppings;
    }
    
    public void setAdditionalToppings(ArrayList<String> additionalToppings) {
        this.additionalToppings = additionalToppings;
    }
    
    public String getSauce() {
        return sauce;
    }
    
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    
    public boolean isToasted() {
        return this.toasted;
    }
    
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}

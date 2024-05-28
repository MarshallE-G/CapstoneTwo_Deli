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
    
    // Getters and Setters
}

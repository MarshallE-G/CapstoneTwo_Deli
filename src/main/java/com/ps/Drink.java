package com.ps;

/*
Represents a "drink"
 */

public class Drink extends Product {
    private String drinkSize;
    private String flavor;
    
    public Drink(String drinkSize, String flavor) {
        super();
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }
    
    @Override
    public double calcPrice() {
        double price = 0;
        
        switch (this.drinkSize.toLowerCase()) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
        }
        
        return price;
    }
    
    
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
    
    @Override
    public String toString() {
        double price = this.calcPrice();
    
        return "Drink:" +
                "\n- Size: " + this.drinkSize +
                "\n- Flavor: " + this.flavor +
                "\n\nPrice: $" + price +
                "\n";
    }
}

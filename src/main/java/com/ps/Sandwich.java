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
    private boolean           hasMeat;
    private boolean           hasCheese;
    private boolean           extraMeat;
    private boolean           extraCheese;
    private ArrayList<String> additionalToppings; // ■ Other toppings:      <--------- These are FREE!!!
    private String            sauce;
    private boolean           toasted;
    
    public Sandwich(
            double price,
            String breadType,
            String sandwichSize,
            String meat,
            String cheese,
            boolean hasMeat,
            boolean hasCheese,
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
        this.hasMeat = hasMeat;
        this.hasCheese = hasCheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.additionalToppings = additionalToppings;
        this.sauce = sauce;
        this.toasted = toasted;
    }
    
    @Override
    public double calcPrice() {
        double price = 0;
        
        switch (this.sandwichSize) {
            case "4\"":
                price = 5.50;
                if (this.hasMeat) {
                    price += 1.00;
                    if (this.extraMeat) {
                        price += .50;
                    }
                }
                
                if (this.hasCheese) {
                    price += .75;
                    if (this.extraCheese) {
                        price += .30;
                    }
                }
                break;
            
            case "8\"":
                price = 7.00;
                if (this.hasMeat) {
                    price += 2.00;
                    if (this.extraMeat) {
                        price += 1.00;
                    }
                }
                
                if (this.hasCheese) {
                    price += 1.50;
                    if (this.extraCheese) {
                        price += .60;
                    }
                }
                break;
            
            case "12\"":
                price = 8.50;
                if (this.hasMeat) {
                    price += 3.00;
                    if (this.extraMeat) {
                        price += 1.50;
                    }
                }
                
                if (this.hasCheese) {
                    price += 2.25;
                    if (this.extraCheese) {
                        price += .90;
                    }
                }
                break;
            default:
        }
        return price;
    }
    
    public void addAdditionalTopping(String additionalTopping) {
        this.additionalToppings.add(additionalTopping);
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
    
    public boolean hasMeat() {
        return hasMeat;
    }
    
    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }
    
    public boolean hasCheese() {
        return hasCheese;
    }
    
    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
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
    
    @Override
    public String toString() {
        String additionalToppingsStr = "";
        for (int i = 0; i < this.additionalToppings.size(); i++) {
            additionalToppingsStr += " " + this.additionalToppings.get(i);
        }
        
        // Make sure to not add an extra space BEFORE additionalToppingsStr!
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", sandwichSize='" + sandwichSize + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", hasMeat=" + hasMeat +
                ", hasCheese=" + hasCheese +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                ", additionalToppings=" + additionalToppingsStr +
                ", sauce='" + sauce + '\'' +
                ", toasted=" + toasted +
                '}';
    }
}

package com.ps;

/*
Represents a "sandwich"
 */

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private String            breadType;
    private String            sandwichSize;
    private String            meat;
    private String            cheese;
    private ArrayList<String> additionalToppings;
    private ArrayList<String> sauces;
    private ArrayList<String> sides;
    private boolean           hasMeat;
    private boolean           extraMeat;
    private boolean           hasCheese;
    private boolean           extraCheese;
    private boolean           hasOtherToppings;
    private boolean           extraToppings;
    private boolean           hasSauces;
    private boolean           extraSauces;
    private boolean           hasSides;
    private boolean           extraSides;
    private boolean           isToasted;
    
    public Sandwich(
            String breadType,
            String sandwichSize,
            String meat,
            String cheese,
            boolean extraMeat,
            boolean extraCheese,
            ArrayList<String> additionalToppings,
            boolean extraToppings,
            ArrayList<String> sauces,
            boolean extraSauces,
            ArrayList<String> sides,
            boolean extraSides,
            boolean isToasted) {
        super();
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.meat = meat;
        this.cheese = cheese;
        this.additionalToppings = additionalToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.hasMeat = this.has(this.meat);
        this.extraMeat = extraMeat;
        this.hasCheese = this.has(this.cheese);
        this.extraCheese = extraCheese;
        this.hasOtherToppings = this.has(this.additionalToppings);
        this.extraToppings = extraToppings;
        this.hasSauces = this.has(this.sauces);
        this.extraSauces = extraSauces;
        this.hasSides = this.has(this.sides);
        this.extraSides = extraSides;
        this.isToasted = isToasted;
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
    
    public boolean has(String topping) {
        return !topping.equalsIgnoreCase("no meat")
                && !topping.equalsIgnoreCase("no cheese");
    }
    
    public boolean has(ArrayList<String> toppings) {
        return !toppings.get(0).equalsIgnoreCase("no toppings")
                && !toppings.get(0).equalsIgnoreCase("no sauce")
                && !toppings.get(0).equalsIgnoreCase("no side");
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
    
    public ArrayList<String> getAdditionalToppings() {
        return additionalToppings;
    }
    
    public void setAdditionalToppings(ArrayList<String> additionalToppings) {
        this.additionalToppings = additionalToppings;
    }
    
    public ArrayList<String> getSauces() {
        return sauces;
    }
    
    public void setSauces(ArrayList<String> sauce) {
        this.sauces = sauce;
    }
    
    public ArrayList<String> getSides() {
        return sides;
    }
    
    public void setSides(ArrayList<String> sides) {
        this.sides = sides;
    }
    
    public boolean hasMeat() {
        return hasMeat;
    }
    
    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }
    
    public boolean hasExtraMeat() {
        return this.extraMeat;
    }
    
    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    
    public boolean hasCheese() {
        return hasCheese;
    }
    
    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }
    
    public boolean hasExtraCheese() {
        return this.extraCheese;
    }
    
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
    
    public boolean hasOtherToppings() {
        return hasOtherToppings;
    }
    
    public void setHasOtherToppings(boolean hasOtherToppings) {
        this.hasOtherToppings = hasOtherToppings;
    }
    
    public boolean hasExtraToppings() {
        return extraToppings;
    }
    
    public void setExtraToppings(boolean extraToppings) {
        this.extraToppings = extraToppings;
    }
    
    public boolean hasSauces() {
        return hasSauces;
    }
    
    public void setHasSauces(boolean hasSauces) {
        this.hasSauces = hasSauces;
    }
    
    public boolean hasExtraSauces() {
        return extraSauces;
    }
    
    public void setExtraSauces(boolean extraSauces) {
        this.extraSauces = extraSauces;
    }
    
    public boolean hasSides() {
        return hasSides;
    }
    
    public void setHasSides(boolean hasSides) {
        this.hasSides = hasSides;
    }
    
    public boolean hasExtraSides() {
        return extraSides;
    }
    
    public void setExtraSides(boolean extraSides) {
        this.extraSides = extraSides;
    }
    
    public boolean isToasted() {
        return this.isToasted;
    }
    
    public void setToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }
    
    public String listToString(List<String> list) {
        String listAsStr = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                listAsStr += list.get(i);
            } else {
                listAsStr += ", " + list.get(i);
            }
        }
        
        return listAsStr;
    }
    
    public String listToString(List<String> list, String listAsStr) {
        for (int i = 0; i < list.size(); i++) {
            listAsStr += "\n\t- " + list.get(i);
        }
        
        return listAsStr;
    }
    
    @Override
    public String toString() {
        double price = this.calcPrice();

        String selectedAddOns =
                "Sandwich: " +
                "\n- Bread: " + breadType +
                "\n- sandwichSize='" + sandwichSize +
                "\n- meat='" + meat +
                "\n- cheese='" + cheese +
                "\n- Additional toppings:";
        selectedAddOns += listToString(this.additionalToppings, selectedAddOns);
    
        selectedAddOns += "\n- Sauces:";
        selectedAddOns += listToString(this.sauces, selectedAddOns);
    
        selectedAddOns += "\n- Sides:";
        selectedAddOns += listToString(this.sides, selectedAddOns);

        if (this.extraMeat) {
            selectedAddOns += "\n- extraMeat=" + this.extraMeat;
        }
        if (this.extraCheese) {
            selectedAddOns += "\n- extraCheese=" + this.extraCheese;
        }
        if (this.extraToppings) {
            selectedAddOns += "\n- extraToppings=" + this.extraToppings;
        }
        if (this.extraSauces) {
            selectedAddOns += "\n- extraSauces=" + this.extraSauces;
        }
        if (this.extraSides) {
            selectedAddOns += "\n- extraSides=" + this.extraSides;
        }
        
        if (isToasted) {
            selectedAddOns += "\n- NOT toasted";
        } else {
            selectedAddOns += "\n- Toasted";
        }

        selectedAddOns +=
                "\n\nPrice: $" + price +
                "\n";

        return selectedAddOns;
    }
}

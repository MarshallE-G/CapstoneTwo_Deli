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
    private boolean           hasMeat;
    private boolean           hasCheese;
    private boolean           extraMeat;
    private boolean           extraCheese;
    private ArrayList<String> additionalToppings; // ■ Other toppings:      <--------- These are FREE!!!
    private boolean           hasOtherToppings;

    private boolean           extraToppings;
    private ArrayList<String> sauces;
    private boolean           hasSauces;
    private boolean           extraSauces;
    private ArrayList<String> sides;
    private boolean           hasSides;
    private boolean           extraSides;
    private boolean           toasted;
    
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
            boolean toasted) {
        super();
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.meat = meat;
        this.cheese = cheese;
        this.hasMeat = this.has(this.meat);
        this.hasCheese = this.has(this.cheese);
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.additionalToppings = additionalToppings;
        this.hasOtherToppings = this.has(this.additionalToppings);
        this.extraToppings = extraToppings;
        this.sauces = sauces;
        this.hasSauces = this.has(this.sauces);
        this.extraSauces = extraSauces;
        this.sides = sides;
        this.hasSides = this.has(this.sides);
        this.extraSides = extraSides;
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
    
    public ArrayList<String> getSauces() {
        return sauces;
    }
    
    public void setSauces(ArrayList<String> sauce) {
        this.sauces = sauce;
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
    
    public ArrayList<String> getSides() {
        return sides;
    }
    
    public void setSides(ArrayList<String> sides) {
        this.sides = sides;
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
        return this.toasted;
    }
    
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    
    public String listToString(List<String> list) {
        String listStr = "";
        for (int i = 0; i < list.size(); i++) {
            listStr += " " + list.get(i);
        }
        
        return listStr;
    }
    
//    public String createStrBasedOnAddOns() {
//        String additionalToppingsStr = listToString(this.additionalToppings);
//        String saucesStr = listToString(this.sauces);
//        String sidesStr = listToString(this.sides);
//        double price = this.calcPrice();
//
//        String selectedAddOns = "Sandwich{" +
//                "breadType='" + breadType + '\'' +
//                ", sandwichSize='" + sandwichSize + '\'' +
//                ", meat='" + meat + '\'' +
//                ", cheese='" + cheese + '\'' +
//                ", additionalToppings='" + additionalToppingsStr + '\'' +
//                ", sauces='" + saucesStr + '\'' +
//                ", sides='" + sidesStr + '\'';
//
//        if (this.extraMeat) {
//            selectedAddOns += ", extraMeat=" + this.extraMeat;
//        }
//        if (this.extraCheese) {
//            selectedAddOns += ", extraCheese=" + this.extraCheese;
//        }
//        if (this.extraToppings) {
//            selectedAddOns += ", extraToppings=" + this.extraToppings;
//        }
//        if (this.extraSauces) {
//            selectedAddOns += ", extraSauces=" + this.extraSauces;
//        }
//        if (this.extraSides) {
//            selectedAddOns += ", extraSides=" + this.extraSides;
//        }
//
//        selectedAddOns +=
//                ", toasted=" + toasted +
//                "\nprice= " + price +
//                '}';
//
//        return selectedAddOns;
//    }
    
    @Override
    public String toString() {
        String additionalToppingsStr = listToString(this.additionalToppings);
        String saucesStr = listToString(this.sauces);
        String sidesStr = listToString(this.sides);
        double price = this.calcPrice();
        
        // Make sure to not add an extra space BEFORE additionalToppingsStr!
//        String sandwichStr = this.createStrBasedOnAddOns();
//        return sandwichStr;
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", sandwichSize='" + sandwichSize + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", hasMeat=" + hasMeat +
                ", hasCheese=" + hasCheese +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                ", additionalToppings='" + additionalToppingsStr + '\'' +
                ", hasOtherToppings=" + hasOtherToppings +
                ", extraToppings=" + extraToppings +
                ", sauces='" + saucesStr + '\'' +
                ", hasSauces=" + hasSauces +
                ", extraSauces=" + extraSauces +
                ", sides='" + sidesStr + '\'' +
                ", hasSides=" + hasSides +
                ", extraSides=" + extraSides +
                ", toasted=" + toasted +
                "\nprice= " + price +
                '}';
    }
}

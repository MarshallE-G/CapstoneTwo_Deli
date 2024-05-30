package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    // Have to create a new File everytime there's a new receipt;
    public static void saveReceipt(Order order) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedDateTime = dateTime.format(formatter);
        String fileName = formattedDateTime + ".txt";
        String additionalToppingsStr;
        String saucesStr ;
        String sidesStr;
        
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(
                    "C:\\Users\\Student\\LearnToCode\\capstones\\CapstoneTwo_Deli\\receipts\\" + fileName
            ));
            
            for (Product product : order.getProducts()) {
                if (product instanceof Sandwich) {
                    additionalToppingsStr = ((Sandwich) product).listToString(((Sandwich) product).getAdditionalToppings());
                    saucesStr = ((Sandwich) product).listToString(((Sandwich) product).getSauces());
                    sidesStr = ((Sandwich) product).listToString(((Sandwich) product).getSides());
                    
                    bufWriter.write(String.format("%s|%s|%s|%s|%s|%s|%s",
                            ((Sandwich) product).getBreadType(),
                            ((Sandwich) product).getSandwichSize(),
                            ((Sandwich) product).getMeat(),
                            ((Sandwich) product).getCheese(),
                            additionalToppingsStr,
                            saucesStr,
                            sidesStr
                            ));
                    
                    if (((Sandwich) product).hasExtraMeat()) {
                        bufWriter.write("|extra meat");
                    }
                    if (((Sandwich) product).hasExtraCheese()) {
                        bufWriter.write("|extra cheese");
                    }
                    if (((Sandwich) product).hasExtraToppings()) {
                        bufWriter.write("|extra topping(s)");
                    }
                    if (((Sandwich) product).hasExtraSauces()) {
                        bufWriter.write("|extra sauce(s)");
                    }
                    if (((Sandwich) product).hasExtraSides()) {
                        bufWriter.write("|extra side(s)");
                    }
                    
                    if (((Sandwich) product).isToasted()) {
                        bufWriter.write("|toasted");
                    } else {
                        bufWriter.write("|NOT toasted");
                    }
                    
                    bufWriter.write(String.format("|$%.2f\n", product.calcPrice()));
                    
                } else if (product instanceof Drink) {
                    bufWriter.write(String.format("%s|%s|$%.2f\n",
                            ((Drink) product).getDrinkSize(),
                            ((Drink) product).getFlavor(),
                            product.calcPrice()
                            ));
                    
                } else if (product instanceof Chip) {
                    bufWriter.write(String.format("%s|$%.2f\n",
                            ((Chip) product).getChipType(),
                            product.calcPrice()
                            ));
                }
            }
            
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

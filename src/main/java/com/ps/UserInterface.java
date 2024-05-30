package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    
    // displayDeli() : void
    public static void displayDeli() {
        init();
    }
    // init() : void
    public static void init() {
        
        int homeMenuCommand;
        
        // • Home Screen
        do {
            System.out.printf("%40s\n", "Welcome to DELI-cious!");
            System.out.println("\nHome Menu\n");
            /* - The home screen should give the user the following options. The
               application should continue to run until the user chooses to exit.*/
                // 1) New Order
            System.out.println("1) New Order");
                // 0) Exit - exit the application
            System.out.println("0) Exit");
    
            System.out.println("Please enter your selection here:");
            homeMenuCommand = scanner.nextInt();
            
            switch (homeMenuCommand) {
                case 1:
                    
                    int orderMenuCommand;
                    
                    do {
                        Order order = new Order();
                        
                        // • Order Screen - All entries should show the newest entries first
                        System.out.println("\nOrder Menu\n");
                        
                        System.out.println("1) Add Sandwich");
                        System.out.println("2) Add Drink");
                        System.out.println("3) Add Chips");
                        System.out.println("4) Checkout");
                            // 0) Cancel Order - delete the order and go back to the home page
                        System.out.println("0) Cancel Order");
    
                        System.out.println("Please enter selection here:");
                        orderMenuCommand = scanner.nextInt();
                        
                        switch (orderMenuCommand) {
                            case 1:
                                String[] breadTypesArr = {"white", "wheat", "rye", "wrap"};
                                String[] sandwichSizesArr = {"4\"", "8\"", "12\""};
                                String[] meatsArr = {"steak", "ham", "salami", "roast beef", "chicken", "bacon", "no meat"};
                                String[] cheesesArr = {"american", "provolone", "cheddar", "swiss", "no cheese"};
                                String[] additionalToppingsArr = {
                                        "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms", "no toppings"
                                };
                                String[] saucesArr = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette", "no sauce"};
                                String[] sidesArr = {"au jus", "sauce", "no side"};
                                String breadType;
                                String sandwichSize;
                                String meat;
                                String cheese;
                                ArrayList<String> additionalToppings;
                                ArrayList<String> sauces;
                                ArrayList<String> sides;
                                boolean hasMeat = false;
                                boolean hasCheese = false;
                                boolean hasOtherToppings = false;
                                boolean hasSauces = false;
                                boolean hasSides = false;
                                boolean extraMeat;
                                boolean extraCheese;
                                boolean extraToppings;
                                boolean extraSauces;
                                boolean extraSides;
                                boolean isToasted = false;
                                
                                System.out.println("\n~You chose the Add Sandwich option~\n");
                                
                                System.out.println("Select your bread:");
                                    displayOptions(breadTypesArr, "bread type");
        
                                    System.out.println("Enter your selection here:");
                                    int selectedBreadTypeNum = scanner.nextInt();
                                    
                                    breadType = optionSelection(breadTypesArr, selectedBreadTypeNum);
                                    
                                    if (breadType.equals("")) {
                                        System.out.println("That bread is not available at our store.\n");
                                        break;
                                    }
                                    
                                    
                                    
                                System.out.println("Select a sandwich size:");
                                    displayOptions(sandwichSizesArr, "sandwich size");
        
                                    System.out.println("Enter your selection here:");
                                    int selectedSandwichSizeNum = scanner.nextInt();
                                    
                                    sandwichSize = optionSelection(sandwichSizesArr, selectedSandwichSizeNum);
                                    
                                    if (sandwichSize.equals("")) {
                                        System.out.println("Sandwiches do not come in this size.\n");
                                        break;
                                    }
                                
                                    
                                System.out.println("Next, we have your toppings!\n");
                                
                                
                                System.out.println("Select a meat:");
                                    displayOptions(meatsArr, "meat");
        
                                    System.out.println("Enter your selection here:");
                                    int selectedMeatNum = scanner.nextInt();
                                    
                                    meat = optionSelection(meatsArr, selectedMeatNum);
    
                                    if (!meat.equals("") && !meat.equalsIgnoreCase("no meat")) {
                                        System.out.println("\nYou selected: " + meat + "\n");
                                        hasMeat = true;
                                    } else if (meat.equals("")) {
                                        System.out.println("This meat is not available.");
                                        break;
                                    }
                                    extraMeat = processExtraToppingInquiry(hasMeat, "meat");
        
                                    System.out.println("\nExtra meat? " + extraMeat);
                                
                                    
                                    
                                System.out.println("Select a cheese:");
                                    displayOptions(cheesesArr, "cheese");
        
                                    System.out.println("Enter your selection here:");
                                    int selectedCheeseNum = scanner.nextInt();
        
                                    cheese = optionSelection(cheesesArr, selectedCheeseNum);
        
                                    if (!cheese.equals("") && !cheese.equalsIgnoreCase("no cheese")) {
                                        System.out.println("\nYou selected: " + cheese + "\n");
                                        hasCheese = true;
                                    } else if (cheese.equals("")) {
                                        System.out.println("This cheese is not available.");
                                        break;
                                    }
                                    extraCheese = processExtraToppingInquiry(hasCheese, "cheese");
        
                                    System.out.println("\nExtra cheese? " + extraCheese + "\n");
                                
                                    
                                
                                System.out.println("Select additional toppings:");
                                    displayOptions(additionalToppingsArr, "additional topping");
                                    
                                    additionalToppings = multiOptionSelection(additionalToppingsArr, "additional topping");
        
                                    System.out.println();
                                    for (String topping : additionalToppings) {
                                        System.out.println(topping);
                                    }
                                    System.out.println();
                                    
                                    if (!additionalToppings.get(0).equalsIgnoreCase("no toppings")) {
                                        hasOtherToppings = true;
                                    }
                                    
                                    extraToppings = processExtraToppingInquiry(hasOtherToppings, "additional toppings");
                                    
                                    System.out.println("\nExtra additional toppings? " + extraToppings + "\n");
                                
                                    
                                    
                                System.out.println("Select sauces:");
                                    displayOptions(saucesArr, "sauce");
        
                                    sauces = multiOptionSelection(saucesArr, "sauce");
        
                                    System.out.println();
                                    for (String sauce : sauces) {
                                        System.out.println(sauce);
                                    }
                                    System.out.println();
        
                                    if (!sauces.get(0).equalsIgnoreCase("no sauces")) {
                                        hasSauces = true;
                                    }
        
                                    extraSauces = processExtraToppingInquiry(hasSauces, "sauce");
        
                                    System.out.println("\nExtra sauces? " + extraSauces + "\n");
                                
                                    
                                    
                                System.out.println("Select sides:");
                                    displayOptions(sidesArr, "side");
    
                                    sides = multiOptionSelection(sidesArr, "side");
        
                                    System.out.println();
                                    for (String side : sides) {
                                        System.out.println(side);
                                    }
                                    System.out.println();
        
                                    if (!sides.get(0).equalsIgnoreCase("no sides")) {
                                        hasSides = true;
                                    }
        
                                    extraSides = processExtraToppingInquiry(hasSides, "side");
                                    System.out.println("\nExtra sides? " + extraSides + "\n");
                                
                                    
                                    
                                int selectedOptionNum = 0;
                                do {
                                    System.out.println("Would you like the sandwich toasted? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                                    selectedOptionNum = scanner.nextInt();
    
                                    switch (selectedOptionNum) {
                                        case 1:
                                            isToasted = true;
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("ERROR: Must type 1 or 0!\n");
                                            break;
                                    }
                                } while (selectedOptionNum != 1 && selectedOptionNum != 0);
                                System.out.println("\nSandwich is toasted? " + isToasted + "\n");
                                
                                Sandwich sandwich = new Sandwich(
                                        breadType,
                                        sandwichSize,
                                        meat,
                                        cheese,
                                        extraMeat,
                                        extraCheese,
                                        additionalToppings,
                                        extraToppings,
                                        sauces,
                                        extraSauces,
                                        sides,
                                        extraSides,
                                        isToasted
                                );
                                System.out.println(sandwich);
                                
                                order.add(sandwich);
                                break;
                            case 2:
                                String[] drinkSizesArr = {"small", "medium", "large"};
                                String[] flavorsArr = {
                                        "pineapple soda", "mango soda", "cherry soda", "strawberry soda",
                                        "blue raspberry soda", "coca-cola", "root beer", "dr. pepper", "mountain dew",
                                        "sprite", "lemonade", "strawberry lemonade"
                                };
                                String drinkSize;
                                String flavor;
                                
                                System.out.println("\n~You chose the Add Drink option~\n");
                                
                                
                                // • Add Drink - select drink size and flavor
                                System.out.println("Select your drink size:");
                                    displayOptions(drinkSizesArr, "drink size");
                                    
                                    System.out.println("Please enter your selection here:");
                                    int selectedDrinkSizeNum = scanner.nextInt();
                                    
                                    drinkSize = optionSelection(drinkSizesArr, selectedDrinkSizeNum);
                                    System.out.println("\nYou selected a \"" + drinkSize + "\" drink size.\n");
                                
                                
                                
                                System.out.println("Select a flavor:");
                                    displayOptions(flavorsArr, "flavor");
                                    
                                    System.out.println("Please enter your selection here:");
                                    int selectedFlavorNum = scanner.nextInt();
                                    
                                    flavor = optionSelection(flavorsArr, selectedFlavorNum);
                                    System.out.println("\nYou selected the \"" + flavor + "\".\n");
                                
                                Drink drink = new Drink(drinkSize, flavor);
                                System.out.println(drink);
                                
                                order.add(drink);
                                break;
                            case 3:
                                String[] chipTypeArr = {
                                        "flamin' hot cheetos (crunchy)", "flamin' hot cheetos (puffy)", "red doritos",
                                        "blue doritos", "potato chips", "bbq chips", "cheddar cheese",
                                        "sour cream & onion", "salt & vinegar", "takis", "hot fries"
                                };
                                String chipType;
                                
                                System.out.println("\n~You chose the Add Chips option~\n");
                                
                                
                                System.out.println("Select your chip type:");
                                    displayOptions(chipTypeArr, "chip type");
                                    
                                    System.out.println("Please enter your selection here:");
                                    int selectedChipTypeNum = scanner.nextInt();
                                    
                                    chipType = optionSelection(chipTypeArr, selectedChipTypeNum);
        
                                    System.out.println("\nYou selected \"" + chipType + "\"\n");
                                
                                Chip chip = new Chip(chipType);
                                System.out.println(chip);
                                
                                order.add(chip);
                                break;
                            case 4:
                                System.out.println("\n~You chose the Checkout option~\n");
                                // • Checkout - display the order details and the price
                                
                                    // - Confirm - create the receipt file and go back to the home screen
                                System.out.println("1) Confirm");
                                
                                    // - Cancel - delete order and go back to the home screen
                                System.out.println("0) Cancel");
                                
                                        // if cancel...
                                            // remove order
                                order.clear();
                                System.out.println("~~You have canceled the order!~~");
//                                orderMenuCommand = 0;
                            case 0:
                                System.out.println("\nReturning to Home Menu...\n");
                                break;
                            default:
                                // Add error msg
                        }


                    } while (orderMenuCommand != 0);
                    break;
                case 0:
                    System.out.println("\nExiting...\n");
                    break;
                default:
                    // Add error msg
            }

        } while (homeMenuCommand != 0);
        scanner.close();
    }
    
    public static void displayHomeMenu() {
    
    }
    
    public static void displayOrderMenu() {
    
    }
    
    public static void processAddSandwichRequest() {
    
    }
    
    
    public static void processAddDrinkRequest() {
    
    }
    
    public static void processAddChipsRequest() {
    
    }
    
    public static void displayOptions(String[] optionsArr, String optionsType) {
        String lastOption = optionsArr[optionsArr.length - 1];
    
        for (int i = 0; i < optionsArr.length; i++) {
            if (
                    (optionsType.equalsIgnoreCase("additional topping")
                    || optionsType.equalsIgnoreCase("sauce")
                    || optionsType.equalsIgnoreCase("side"))
                    && optionsArr[i].equalsIgnoreCase(lastOption)
            ) {
                System.out.println(
                        "\t" + (i + 1) + ") " + optionsArr[i] +
                                " (Selecting this option will remove all previous add-ons)"
                );
            } else {
                System.out.println("\t" + (i + 1) + ") " + optionsArr[i]);
            }
        }
        System.out.println();
    }
    
    public static void displayNewOptions(ArrayList<String> allOptions, int selectedOptionNum) {
        Iterator<String> iterator = allOptions.iterator();
        String lastOption = allOptions.get(allOptions.size() - 1);
        String selectedOption = allOptions.get(selectedOptionNum-1);
        
        
            while (iterator.hasNext()) {
                String option = iterator.next();
                if (
                        !option.equalsIgnoreCase(lastOption) &&
                                option.equalsIgnoreCase(selectedOption)
                ) {
                    iterator.remove();
                }
            }
    
        for (int i = 0; i < allOptions.size(); i++) {
            if (!allOptions.get(i).equalsIgnoreCase(lastOption)) {
                System.out.println("\t" + (i+1) + ") " + allOptions.get(i));
            } else {
                System.out.println(
                        "\t" + (i + 1) + ") " + allOptions.get(i) +
                                " (Selecting this option will remove all previous add-ons)"
                );
            }
        }
        
        System.out.println();
    }
    
    public static String optionSelection(String[] optionsArr, int selectedOptionNum) {
        String optionItem = "";
        
        for (int i = 1; i < optionsArr.length; i++) {
            if (selectedOptionNum == 1) {
                optionItem = optionsArr[0];
            } else if (selectedOptionNum == i+1) {
                optionItem = optionsArr[i];
            }
        }
        
        return optionItem;
    }
    
    public static String optionSelection(ArrayList<String> options, int selectedOptionNum) {
        String optionItem = "";
        
        for (int i = 1; i < options.size(); i++) {
            if (selectedOptionNum == 1) {
                optionItem = options.get(0);
            } else if (selectedOptionNum == i+1) {
                optionItem = options.get(i);
            }
        }
        
        return optionItem;
    }
    
    public static ArrayList<String> multiOptionSelection(String[] optionsArr, String optionType) {
        ArrayList<String> selectedOptionItems = new ArrayList<>();
        ArrayList<String> allOptions = new ArrayList<>();
        boolean wantsMoreOptions = false;
        boolean duplicateOptions = false;
        int selectedOptionNum = 0;
        int additionalOptionNumChoice = 0;
        int count = 0;
        String selectedOptionItem = "";
    
        for (int i = 0; i < optionsArr.length; i++) {
            allOptions.add(optionsArr[i]);
        }
        String lastOption = allOptions.get(allOptions.size()-1);
        
        do {
            if (count > 0 && selectedOptionNum < allOptions.size()+1) {
                displayNewOptions(allOptions, selectedOptionNum);
            }
            
            System.out.println("Enter your selection here:");
            selectedOptionNum = scanner.nextInt();
    
            selectedOptionItem = optionSelection(allOptions, selectedOptionNum);
    
            if (selectedOptionNum < allOptions.size()+1 && !selectedOptionItem.equalsIgnoreCase(lastOption)) {
                
                for (int i = 0; i < selectedOptionItems.size(); i++) {
                    if (selectedOptionItem.equalsIgnoreCase(selectedOptionItems.get(i))) {
                        duplicateOptions = true;
                        System.out.println("\nYou have already added this " + optionType + "!\n");
                        break;
                    } else {
                        duplicateOptions = false;
                    }
                }
                if (!duplicateOptions) {
                    selectedOptionItems.add(selectedOptionItem);
                    ++count;
                }
            } else if (selectedOptionItem.equalsIgnoreCase(lastOption)) {
                selectedOptionItems.clear();
                selectedOptionItems.add(selectedOptionItem);
                System.out.println("\n\tYou selected the \"" + selectedOptionItem + "\" option\n");
                break;
            } else {
                System.out.println("\nERROR: Must type a number that corresponds with an option listed! (e.g. 1)\n");
                continue;
            }
            
            do {
                System.out.println("Would you like to add another " + optionType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                additionalOptionNumChoice = scanner.nextInt();
    
                switch (additionalOptionNumChoice) {
                    case 1:
                        wantsMoreOptions = true;
                        break;
                    case 0:
                        wantsMoreOptions = false;
                        break;
                    default:
                        System.out.println("\nERROR: Must type 1 or 0!\n");
                        break;
                }
            } while(additionalOptionNumChoice != 1 && additionalOptionNumChoice != 0);
        } while (wantsMoreOptions && count < optionsArr.length-1);
        
        if (count == optionsArr.length-1 && (wantsMoreOptions)) {
            System.out.println("\n\tYou cannot add another " + optionType + " as there are only " + (optionsArr.length-1) + " available.\n");
        }
        
        return selectedOptionItems;
    }
    
    public static boolean processExtraToppingInquiry(boolean hasTopping, String toppingType) {
        boolean extraToppingOption = false;
        
        int optionNumChoice = 0;
        do {
            if (hasTopping) {
                System.out.println("Would you like extra " + toppingType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                optionNumChoice = scanner.nextInt();
                
                switch (optionNumChoice) {
                    case 1:
                        extraToppingOption = true;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("ERROR: Must type 1 or 0!\n");
                        break;
                }
            }
        } while (optionNumChoice != 1 && optionNumChoice != 0);
        
        return extraToppingOption;
    }
    
//    public static void processCheckoutRequest(int orderMenuCommand) {
//        System.out.println("\n~You chose the Checkout option~\n");
//        // • Checkout - display the order details and the price
//
//            // - Confirm - create the receipt file and go back to the home screen
//        System.out.println("1) Confirm");
//
//            // - Cancel - delete order and go back to the home screen
//        System.out.println("0) Cancel");
//
//                // if cancel...
//                    // remove order
//        System.out.println("~~You have canceled the order!~~");
//        orderMenuCommand = 0;
//    }
    
    
    //  Might add a back button that you can press... at (almost) anytime. Might require a whole Generic Class
        // Step 1: Back button will be... 0!!!
    
}

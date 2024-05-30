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
                                ArrayList<String> additionalToppings = new ArrayList<>();
                                ArrayList<String> sauces = new ArrayList<>();
                                ArrayList<String> sides = new ArrayList<>();
//                                HashMap<String[], String> toppingsTypeHashMap = new HashMap<>();
                                boolean hasMeat = false;
                                boolean hasCheese = false;
                                boolean hasOtherToppings = false;
                                boolean hasSauces = false;
                                boolean hasSides = false;
                                boolean extraMeat = false;
                                boolean extraCheese = false;
                                boolean extraToppings = false;
                                boolean extraSauces = false;
                                boolean extraSides = false;
//                                toppingsTypeHashMap.put(meatsArr, "meat");
//                                toppingsTypeHashMap.put(cheesesArr, "cheese");
//                                toppingsTypeHashMap.put(additionalToppingsArr, "additional toppings");
//                                toppingsTypeHashMap.put(saucesArr, "sauces");
//                                toppingsTypeHashMap.put(sidesArr, "sides");
                                
                                /* • Add Sandwich - the add sandwich screen will walk the user through
                                   several options to create the sandwich*/
                                System.out.println("\n~You chose the Add Sandwich option~\n");
                                
                                    // - Select your bread:
                                System.out.println("Select your bread:");
                                displaySandwichOptions(breadTypesArr, "bread type");
    
                                System.out.println("Enter your selection here:");
                                int breadSelection = scanner.nextInt();
                                
                                String breadType = sandwichOptionSelection(breadTypesArr, breadSelection);
                                
                                if (breadType.equals("")) {
                                    System.out.println("That bread is not available at our store.\n");
                                    break;
                                }
    
                                    // - Sandwich size:
                                System.out.println("Select a sandwich size:");
                                displaySandwichOptions(sandwichSizesArr, "sandwich size");
    
                                System.out.println("Enter your selection here:");
                                int sandwichSizeSelection = scanner.nextInt();
                                
                                String sandwichSize = sandwichOptionSelection(sandwichSizesArr, sandwichSizeSelection);
                                
                                if (sandwichSize.equals("")) {
                                    System.out.println("Sandwiches do not come in this size.\n");
                                    break;
                                }
                                
                                System.out.println("Next, we have your toppings!\n");
                                System.out.println("Select a meat:");
                                
                                displaySandwichOptions(meatsArr, "meat");
    
                                System.out.println("Enter your selection here:");
                                int meatSelection = scanner.nextInt();
                                
                                String meat = sandwichOptionSelection(meatsArr, meatSelection);

                                if (!meat.equals("") && !meat.equalsIgnoreCase("no meat")) {
                                    System.out.println("\nYou selected: " + meat + "\n");
                                    hasMeat = true;
                                } else if (meat.equals("")) {
                                    System.out.println("This meat is not available.");
                                    break;
                                }
                                extraMeat = processExtraToppingInquiry(hasMeat, "meat");
    
                                System.out.println("\nExtra meat? " + extraMeat);
                                
                                        // ■ Cheese:
                                            // display list of available cheeses
                                System.out.println("Select a cheese:");
                                displaySandwichOptions(cheesesArr, "cheese");
    
                                System.out.println("Enter your selection here:");
                                int cheeseSelection = scanner.nextInt();
    
                                String cheese = sandwichOptionSelection(cheesesArr, cheeseSelection);
    
                                if (!cheese.equals("") && !cheese.equalsIgnoreCase("no cheese")) {
                                    System.out.println("\nYou selected: " + cheese + "\n");
                                    hasCheese = true;
                                } else if (cheese.equals("")) {
                                    System.out.println("This cheese is not available.");
                                    break;
                                }
                                extraCheese = processExtraToppingInquiry(hasCheese, "cheese");
    
                                System.out.println("\nExtra cheese? " + extraCheese + "\n");
                                
                                        // ■ Other toppings:
                                            // display list of additional toppings (these are FREE)
                                System.out.println("Select additional toppings:");
                                displaySandwichOptions(additionalToppingsArr, "additional topping");
                                
                                additionalToppings = sandwichMultiOptionSelection(additionalToppingsArr, "additional topping");
    
                                System.out.println();
                                for (String topping : additionalToppings) {
                                    System.out.println(topping);
                                }
                                System.out.println();
                                
                                            // if there's additional toppings...
                                System.out.println("Would you like extra additional toppings? (Y/N)");
                                
                                        // ■ Select sauces:
                                            // display list of available sauces
                                
                                
                                            // ----> for or do-while loop (for multiple toppings)
                                            // add all sauces to sauces ArrayList
    
    
                                            // if there's sauce(s)...
                                System.out.println("Would you like extra sauce? (Y/N)");
                                
                                        // ■ Select sides:
                                            // display list of available sides
    
                                
                                            // ----> for or do-while loop (for multiple sides)
                                            // add all sides to sides ArrayList
    
    
                                            // if there's side(s)...
                                System.out.println("Would you like extra sides? (Y/N)");
                                
                                    // - Would you like the sandwich toasted?
                                System.out.println("Would you like the sandwich toasted?");
                                
                                break;
                            case 2:
                                System.out.println("\n~You chose the Add Drink option~\n");
                                
                                // • Add Drink - select drink size and flavor
                                System.out.println("Select your drink size:");
    
                                    // display all available drink sizes (small, medium, and large)
    
                                System.out.println("Please enter your selection here:");
                                
                                System.out.println("Select a flavor:");
                                
                                    // display all available drink flavors (e.g. pineapple, mango, cherry, etc.)
                                
                                System.out.println("Please enter your selection here:");
                                
                                break;
                            case 3:
                                System.out.println("\n~You chose the Add chips option~\n");
                                
                                // • Add Chips - select chip type
                                System.out.println("Select your chip type:");
    
                                    // display all available chips
    
                                System.out.println("Please enter your selection here:");
                                
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
    
    public static void displaySandwichOptions(String[] optionsArr, String optionsType) {
        String lastElement = optionsArr[optionsArr.length - 1];
    
        for (int i = 0; i < optionsArr.length; i++) {
            if (
                    (optionsType.equalsIgnoreCase("additional topping")
                    || optionsType.equalsIgnoreCase("sauce")
                    || optionsType.equalsIgnoreCase("side"))
                    && optionsArr[i].equalsIgnoreCase(lastElement)
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
    
    public static void displayNewSandwichOptions(ArrayList<String> allOptions, int selection) {
        Iterator<String> iterator = allOptions.iterator();
        String lastElement = allOptions.get(allOptions.size() - 1);
        String selectedElement = allOptions.get(selection-1);
        
        
            while (iterator.hasNext()) {
                String option = iterator.next();
                if (
                        !option.equalsIgnoreCase(lastElement) &&
                                option.equalsIgnoreCase(selectedElement)
                ) {
                    iterator.remove();
                }
            }
    
        for (int i = 0; i < allOptions.size(); i++) {
            if (!allOptions.get(i).equalsIgnoreCase(lastElement)) {
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
    
    public static String sandwichOptionSelection(String[] optionsArr, int selection) {
        String optionItem = "";
        
        for (int i = 1; i < optionsArr.length; i++) {
            if (selection == 1) {
                optionItem = optionsArr[0];
            } else if (selection == i+1) {
                optionItem = optionsArr[i];
            }
        }
        
        return optionItem;
    }
    
    public static String sandwichOptionSelection(ArrayList<String> options, int selection) {
        String optionItem = "";
        
        for (int i = 1; i < options.size(); i++) {
            if (selection == 1) {
                optionItem = options.get(0);
            } else if (selection == i+1) {
                optionItem = options.get(i);
            }
        }
        
        return optionItem;
    }
    
    public static ArrayList<String> sandwichMultiOptionSelection(String[] optionsArr, String toppingType) {
        ArrayList<String> toppingItems = new ArrayList<>();
        ArrayList<String> allOptions = new ArrayList<>();
        boolean wantsMoreTopping = false;
        boolean duplicateToppings = false;
        int toppingsSelectionNum = 0;
        int optionNumChoice = 0;
        int count = 0;
        String toppingItem = "";
    
        for (int i = 0; i < optionsArr.length; i++) {
            allOptions.add(optionsArr[i]);
        }
        String lastElement = allOptions.get(allOptions.size()-1);
        
        do {
            if (count > 0 && toppingsSelectionNum < allOptions.size()+1) {
                displayNewSandwichOptions(allOptions, toppingsSelectionNum);
            }
            
            System.out.println("Enter your selection here:");
            toppingsSelectionNum = scanner.nextInt();
    
            toppingItem = sandwichOptionSelection(allOptions, toppingsSelectionNum);
    
            if (toppingsSelectionNum < allOptions.size()+1 && !toppingItem.equalsIgnoreCase(lastElement)) {
                
                for (int i = 0; i < toppingItems.size(); i++) {
                    if (toppingItem.equalsIgnoreCase(toppingItems.get(i))) {
                        duplicateToppings = true;
                        System.out.println("\nYou have already added this " + toppingType + "!\n");
                        break;
                    } else {
                        duplicateToppings = false;
                    }
                }
                if (!duplicateToppings) {
                    toppingItems.add(toppingItem);
                    ++count;
                }
            } else if (toppingItem.equalsIgnoreCase(lastElement)) {
                toppingItems.clear();
                toppingItems.add(toppingItem);
                System.out.println("\n\tYou selected the \"" + toppingItem + "\" option\n");
                break;
            } else {
                System.out.println("\nERROR: Must type a number that corresponds with an option listed! (e.g. 1)\n");
                continue;
            }
            
            do {
                System.out.println("Would you like to add another " + toppingType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                optionNumChoice = scanner.nextInt();
    
                switch (optionNumChoice) {
                    case 1:
                        wantsMoreTopping = true;
                        break;
                    case 0:
                        wantsMoreTopping = false;
                        break;
                    default:
                        System.out.println("\nERROR: Must type 1 or 0!\n");
                        break;
                }
            } while(optionNumChoice != 1 && optionNumChoice != 0);
        } while (wantsMoreTopping && count < optionsArr.length-1);
        
        if (count == optionsArr.length-1) {
            System.out.println("\n\tYou cannot add another " + toppingType + " as there are only " + (optionsArr.length-1) + " available.\n");
        }
        
        return toppingItems;
    }
    
    public static void processAddSandwichRequest() {
    
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
    
    public static void processAddDrinkRequest() {
    
    }
    
    public static void processAddChipsRequest() {
    
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
    
    /**/
    //  Might add a back button that you can press... at (almost) anytime. Might require a whole Generic Class
        // Step 1: Back button will be... 0!!!
    
}

package com.ps;

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
                                String[] cheesesArr = {"american", "provolone", "cheddar", "swiss"};
                                String[] additionalToppingsArr = {
                                        "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"
                                };
                                String[] saucesArr = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
                                String[] sidesArr = {"au jus", "sauce"};
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
                                
                                /* • Add Sandwich - the add sandwich screen will walk the user through
                                   several options to create the sandwich*/
                                System.out.println("\n~You chose the Add Sandwich option~\n");
                                
                                    // - Select your bread:
                                System.out.println("Select your bread:");
                                displaySandwichOptions(breadTypesArr);
    
                                System.out.println("Enter your selection here:");
                                int breadSelection = scanner.nextInt();
                                
                                String breadType = sandwichOptionSelection(breadTypesArr, breadSelection);
                                
                                if (breadType.equals("")) {
                                    System.out.println("That bread is not available at our store.\n");
                                    break;
                                }
    
                                    // - Sandwich size:
                                System.out.println("Select a sandwich size:");
                                displaySandwichOptions(sandwichSizesArr);
    
                                System.out.println("Enter your selection here:");
                                int sandwichSizeSelection = scanner.nextInt();
                                
                                String sandwichSize = sandwichOptionSelection(sandwichSizesArr, sandwichSizeSelection);
                                
                                if (sandwichSize.equals("")) {
                                    System.out.println("Sandwiches do not come in this size.\n");
                                    break;
                                }
                                
                                System.out.println("Next, we have your toppings!\n");
                                        // ■ Meat:
                                            // display list of available meats
                                System.out.println("Select a meat:");
                                displaySandwichOptions(meatsArr);
    
                                System.out.println("Enter your selection here:");
                                int meatSelection = scanner.nextInt();
                                
                                String meat = sandwichOptionSelection(meatsArr, meatSelection);

                                if (!meat.equals("") && !meat.equalsIgnoreCase("no meat")) {
                                    System.out.println("You selected: " + meat);
                                    hasMeat = true;
                                } else if (meat.equals("")) {
                                    System.out.println("This meat is not available.");
                                    break;
                                }
    
                                // if there's meat...
                                if (hasMeat) {
                                    System.out.println("Would you like extra meat? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                                    int extraToppingChoice = scanner.nextInt();
                                    if (extraToppingChoice == 1) {
                                        extraMeat = true;
                                    } else if (extraToppingChoice == 0) {
                                        extraMeat = false;
                                    } else {
                                        System.out.println("ERROR: Must type 1 or 0!");
                                    }
                                }
                                
                                        // ■ Cheese:
                                            // display list of available cheeses
    
                                            // if there's cheese...
                                System.out.println("Would you like extra cheese? (Y/N)");
                                
                                        // ■ Other toppings:
                                            // display list of additional toppings (these are FREE)
                                
                                
                                            // ----> for or do-while loop (for multiple toppings)
                                            // add all toppings to additionalToppings ArrayList
                                
                                
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
    
    
                                            // if there's sauce(s)...
                                System.out.println("Would you like extra sauce? (Y/N)");
                                
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
    
    public static void displaySandwichOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println("\t" + (i+1) + ") " + options[i]);
        }
        System.out.println();
    }
    
    public static String sandwichOptionSelection(String[] options, int selection) {
        String optionItem = "";
        
        for (int i = 1; i < options.length; i++) {
            if (selection == 1) {
                optionItem = options[0];
            } else if (selection == i+1) {
                optionItem = options[i];
            }
        }
        
        return optionItem;
    }
    
    public static void processAddSandwichRequest() {
    
    }
    
    public static boolean processExtraToppingInquiry(boolean hasOption, String optionType) {
        boolean extraOption = false;
    
        int extraOptionChoice = 0;
        do {
            if (hasOption) {
                System.out.println("Would you like extra " + optionType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                extraOptionChoice = scanner.nextInt();
        
                switch (extraOptionChoice) {
                    case 1:
                        extraOption = true;
                        break;
                    case 0:
                        extraOption = false;
                        break;
                    default:
                        System.out.println("ERROR: Must type 1 or 0!");
                        break;
                }
            }
        } while (extraOptionChoice != 1 && extraOptionChoice != 0);
        
        return extraOption;
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

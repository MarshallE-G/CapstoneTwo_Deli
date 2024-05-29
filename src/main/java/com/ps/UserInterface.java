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
                                String[] cheesesArr;
                                String[] additionalToppingsArr;
                                String[] saucesArr;
                                String[] sidesArr;
                                
                                /* • Add Sandwich - the add sandwich screen will walk the user through
                                   several options to create the sandwich*/
                                System.out.println("\n~You chose the Add Sandwich option~\n");
                                
                                    // - Select your bread:
                                System.out.println(
                                        "Select your bread:\n" +
                                                "\t1) white\n" +
                                                "\t2) wheat\n" +
                                                "\t3) rye\n" +
                                                "\t4) wrap"
                                );
    
                                System.out.println("Enter your selection here:");
                                int breadSelection = scanner.nextInt();
                                
                                if (breadSelection == 1) {
                                    String breadType = "white";
                                } else if (breadSelection == 2) {
                                    String breadType = "wheat";
                                } else if (breadSelection == 3) {
                                    String breadType = "rye";
                                } else if (breadSelection == 4) {
                                    String breadType = "wrap";
                                } else {
                                    System.out.println("That bread is not available at our store.");
                                }
    
                                // - Sandwich size:
                                System.out.println(
                                        "Select a sandwich size:\n" +
                                                "\t1) 4\"\n" +
                                                "\t2) 8\"\n" +
                                                "\t3) 12\""
                                );
    
                                System.out.println("Enter your selection here:");
                                int sandwichSizeSelection = scanner.nextInt();
    
                                if (breadSelection == 1) {
                                    String sandwichSize = "4\"";
                                } else if (breadSelection == 2) {
                                    String sandwichSize = "8\"";
                                } else if (breadSelection == 3) {
                                    String sandwichSize = "12\"";
                                } else {
                                    System.out.println("Sandwiches do not come in this size.");
                                }
                                
                                    // - Toppings: - the user should be able to add extras of each topping
                                        // ■ Meat:
                                            // display list of available meats
                                System.out.println(
                                        "Select a meat:\n" +
                                                "\t1) steak\n" +
                                                "\t2) ham\n" +
                                                "\t3) salami\n" +
                                                "\t4) roast beef\n" +
                                                "\t5) chicken\n" +
                                                "\t6) bacon" +
                                                "\t7) no meat"
                                );
    
                                System.out.println("Enter your selection here:");
                                int meatSelection = scanner.nextInt();
                                
                                sandwichOptionSelection();
    
                                String meat = "";
                                if (meatSelection == 1) {
                                    meat = "steak";
                                } else if (meatSelection == 2) {
                                    meat = "ham";
                                } else if (meatSelection == 3) {
                                    meat = "salami";
                                } else if (meatSelection == 4) {
                                    meat = "roast beef";
                                } else if (meatSelection == 5) {
                                    meat = "chicken";
                                } else if (meatSelection == 6) {
                                    meat = "bacon";
                                } else if (meatSelection == 7) {
                                    meat = "no meat";
                                } else {
                                    System.out.println("This meat is not available.");
                                }
                                
                                if (meat.equals("")) {
                                    meat = "no meat";
                                }
                                
                                            // if there's meat...
                                System.out.println("Would you like extra meat? (Y/N)");
                                
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
    
    // WIP
    public static void displaySandwichOptions(String sandwichOptionType) {
        if (sandwichOptionType.equalsIgnoreCase("bread type")) {
        
        } else if (sandwichOptionType.equalsIgnoreCase("sandwich size")) {
        
        } else if (sandwichOptionType.equalsIgnoreCase("meat")) {
    
        } else if (sandwichOptionType.equalsIgnoreCase("cheese")) {
    
        } else if (sandwichOptionType.equalsIgnoreCase("additional toppings")) {
    
        } else if (sandwichOptionType.equalsIgnoreCase("sauces")) {
    
        } else if (sandwichOptionType.equalsIgnoreCase("sides")) {
    
        }
    }
    
    public static void sandwichOptionSelection(String[] options, int selection) {
//        int optionNum = 1;
        String optionItem;
        
        for (int i = 1; i < (options.length+1); i++) {
            if (selection == 1) {
                optionItem = options[0];
            } else if (selection == i+1) {
                optionItem = options[i];
            }
        }
    }
    
    public static void processAddSandwichRequest() {
    
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
        // Step 1: Will have to create a Generic method that takes (variable = scan.nextInt or scan.nextLine as a parameter...)
    
        // Step 1: Create a "checkWhetherIntOrString()" method
        // Step 2: Overload method with int, THEN String parameter (return type will be a Boolean)
        // Step 3: Create two boolean variables to hold whatever is returned
        // Step 4: Create else-if statement to see whether to use
    
}

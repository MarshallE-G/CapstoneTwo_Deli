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
                                /* • Add Sandwich - the add sandwich screen will walk the user through
                                   several options to create the sandwich*/
                                System.out.println("\n~You chose the Add Sandwich option~\n");
                                
                                    // - Select your bread:
                                System.out.println(
                                        "Select your bread:" +
                                                "\t1) white" +
                                                "\t2) wheat" +
                                                "\t3) rye" +
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
                                        "Select a sandwich size:" +
                                                "\t1) 4\"" +
                                                "\t2) 8\"" +
                                                "\t3) 12\""
                                );
                                    // - Toppings: - the user should be able to add extras of each topping
                                        // ■ Meat:
                                            // display list of available meats
                                
                                            // if there's meat...
                                System.out.println("Would you like extra meat? (Y/N)");
                                
                                        // ■ Cheese:
                                            // display list of available cheeses
    
                                            // if there's cheese...
                                System.out.println("Would you like extra cheese? (Y/N)");
                                
                                        // ■ Other toppings:
                                            // display list of additional toppings (these are FREE)
                                
                                        // ■ Select sauces:
                                            // display list of available sauces
                                
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
    
}

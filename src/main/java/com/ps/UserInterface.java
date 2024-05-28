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
                        System.out.println("\nOrder Screen\n");
                        
                            // 1) Add Sandwich
                        System.out.println("1) Add Sandwich");
                            // 2) Add Drink
                        System.out.println("2) Add Drink");
                            // 3) Add Chips
                        System.out.println("3) Add Chips");
                            // 4) Checkout
                        System.out.println("4) Checkout");
                            // 0) Cancel Order - delete the order and go back to the home page
                        System.out.println("0) Cancel Order");
    
                        System.out.println("Please enter selection here:");
                        orderMenuCommand = scanner.nextInt();
                        
                        switch (orderMenuCommand) {
                            case 1:
                                /* • Add Sandwich - the add sandwich screen will walk the user through
                                   several options to create the sandwich*/
                                    // - Select your bread:
                                    // - Sandwich size:
                                    // - Toppings: - the user should be able to add extras of each topping
                                        // ■ Meat:
                                        // ■ Cheese:
                                        // ■ Other toppings:
                                        // ■ Select sauces:
                                    // - Would you like the sandwich toasted?
                                break;
                            case 2:
                                // • Add Drink - select drink size and flavor
                                break;
                            case 3:
                                // • Add Chips - select chip type
                                break;
                            case 4:
                                // • Checkout - display the order details and the price
                                    // - Confirm - create the receipt file and go back to the home screen
                                    // - Cancel - delete order and go back to the home screen
                                break;
                            default:
                                // Add error msg
                        }


                    } while (orderMenuCommand != 0);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    // Add error msg
            }

        } while (homeMenuCommand != 0);
        scanner.close();
    }
}

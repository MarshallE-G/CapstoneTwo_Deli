package com.ps;

public class UserInterface {
    // displayDeli() : void
    public static void displayDeli() {
        init();
    }
    // init() : void
    public static void init() {
        // • Home Screen
        System.out.printf("%40s\n", "Welcome to DELI-cious!");
            /* - The home screen should give the user the following options. The
               application should continue to run until the user chooses to exit.*/
                // 1) New Order
                // 0) Exit - exit the application
        // • Order Screen - All entries should show the newest entries first
            // 1) Add Sandwich
            // 2) Add Drink
            // 3) Add Chips
            // 4) Checkout
            // 0) Cancel Order - delete the order and go back to the home page
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
        // • Add Drink - select drink size and flavor
        // • Add Chips - select chip type
        // • Checkout - display the order details and the price
            // - Confirm - create the receipt file and go back to the home screen
            // - Cancel - delete order and go back to the home screen
    }
}

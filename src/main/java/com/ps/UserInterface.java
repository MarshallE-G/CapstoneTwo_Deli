package com.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    
    public static void displayDeli() {
        init();
    }
    
    public static void init() {
        displayHomeMenu();
        scanner.close();
    }
    
    public static void displayHomeMenu() {
        int homeMenuCommand;
        do {
            System.out.printf("%52s\u001b[22;23;24m\n", "\u001b[1;3;4mWelcome to the DELI-cious Online Deli!");
            System.out.println("\nHome Menu\n");
        
            System.out.println("1) New Order");
            System.out.println("0) Exit");
        
            System.out.println("\nPlease enter your selection here:");
            homeMenuCommand = scanner.nextInt();
        
            switch (homeMenuCommand) {
                case 1:
                    Order order = new Order();
                    displayOrderMenu(order);
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nERROR: Not a valid option number. Must type 1 or 0!\n");
                    break;
            }
        } while (homeMenuCommand != 0);
    }
    
    public static void displayOrderMenu(Order order) {
        int orderMenuCommand;
        do {
            System.out.println("\nOrder Menu\n");
        
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
        
            System.out.println("\nPlease enter selection here:");
            orderMenuCommand = scanner.nextInt();
        
            switch (orderMenuCommand) {
                case 1:
                    processAddSandwichRequest(order);
                    break;
                case 2:
                    processAddDrinkRequest(order);
                    break;
                case 3:
                    processAddChipsRequest(order);
                    break;
                case 4:
                    if (!order.getProducts().isEmpty()) {
                        System.out.println("\n~You chose the Checkout option~\n");
                    
                        int selectedCheckoutOptionNum;
                        do {
                            order.checkout();
                        
                            System.out.println("\nPlease select an option:");
                            System.out.println("1) Confirm");
                            System.out.println("0) Cancel");
                        
                            System.out.println("\nEnter your selection here:");
                            selectedCheckoutOptionNum = scanner.nextInt();
                        
                            switch (selectedCheckoutOptionNum) {
                                case 1:
                                    System.out.println("\n~~You have confirmed your order!~~");
                                    FileManager.saveReceipt(order);
                                    order.clear();
                                    System.out.println("\n\nReturning to Home Menu...\n");
                                    return;
                                case 0:
                                    System.out.println("\n~~You have canceled the order!~~");
                                    order.clear();
                                    System.out.println("\n\nReturning to Home Menu...\n");
                                    return;
                                default:
                                    System.out.println("\nERROR: Not a valid option number. Must type 1 or 0!\n");
                                    break;
                            }
                        } while (true);
                    } else {
                        System.out.println("\nYou must add items to your order before you can checkout!!\n");
                        break;
                    }
                case 0:
                    System.out.println("\nReturning to Home Menu...\n");
                    return;
                default:
                    System.out.println("\nERROR: Not a valid option number. Must type 1, 2, 3, 4, or 0!\n");
                    break;
            }
        } while (true);
    }
    
    public static void processAddSandwichRequest(Order order) {
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
    
        System.out.println("\n\t~You chose the Add Sandwich option~\n");
    
        System.out.println("Select your bread:");
        displayOptions(breadTypesArr, "bread type");
    
        System.out.println("Enter your selection here:");
            int selectedBreadTypeNum = scanner.nextInt();
        
            breadType = optionSelection(breadTypesArr, selectedBreadTypeNum);
    
            if (!breadType.equals("")) {
                System.out.println("\nYou selected: " + breadType + "\n");
            } else {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
    
    
    
        System.out.println("Select a sandwich size:");
            displayOptions(sandwichSizesArr, "sandwich size");
        
            System.out.println("Enter your selection here:");
            int selectedSandwichSizeNum = scanner.nextInt();
        
            sandwichSize = optionSelection(sandwichSizesArr, selectedSandwichSizeNum);
            
            if (!sandwichSize.equals("")) {
                System.out.println("\nYou selected: " + sandwichSize + "\n");
            } else {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
    
    
        System.out.println("\t~~Next, we have toppings!~~\n");
    
    
        System.out.println("Select a meat:");
            displayOptions(meatsArr, "meat");
        
            System.out.println("Enter your selection here:");
            int selectedMeatNum = scanner.nextInt();
        
            meat = optionSelection(meatsArr, selectedMeatNum);
        
            if (!meat.equals("") && !meat.equalsIgnoreCase("no meat")) {
                System.out.println("\nYou selected: " + meat + "\n");
                hasMeat = true;
            } else if (meat.equals("")) {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
            extraMeat = processExtraToppingInquiry(hasMeat, "meat");
    
    
    
        System.out.println("Select a cheese:");
            displayOptions(cheesesArr, "cheese");
        
            System.out.println("Enter your selection here:");
            int selectedCheeseNum = scanner.nextInt();
        
            cheese = optionSelection(cheesesArr, selectedCheeseNum);
        
            if (!cheese.equals("") && !cheese.equalsIgnoreCase("no cheese")) {
                System.out.println("\nYou selected: " + cheese + "\n");
                hasCheese = true;
            } else if (cheese.equals("")) {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
            extraCheese = processExtraToppingInquiry(hasCheese, "cheese");
    
    
    
        System.out.println("Select additional toppings:");
            displayOptions(additionalToppingsArr, "additional topping");
        
            additionalToppings = multiOptionsSelection(additionalToppingsArr, "additional topping");
        
            System.out.println("Additional toppings selected:");
            for (String topping : additionalToppings) {
                System.out.println("- " + topping);
            }
            System.out.println();
        
            if (!additionalToppings.get(0).equalsIgnoreCase("no toppings")) {
                hasOtherToppings = true;
            }
        
            extraToppings = processExtraToppingInquiry(hasOtherToppings, "additional toppings");
    
    
    
        System.out.println("Select sauces:");
            displayOptions(saucesArr, "sauce");
        
            sauces = multiOptionsSelection(saucesArr, "sauce");
    
            System.out.println("Sauce(s) selected:");
            for (String sauce : sauces) {
                System.out.println("- " + sauce);
            }
            System.out.println();
        
            if (!sauces.get(0).equalsIgnoreCase("no sauce")) {
                hasSauces = true;
            }
        
            extraSauces = processExtraToppingInquiry(hasSauces, "sauce");
    
    
    
        System.out.println("Select sides:");
            displayOptions(sidesArr, "side");
        
            sides = multiOptionsSelection(sidesArr, "side");
    
            System.out.println("Side(s) selected:");
            for (String side : sides) {
                System.out.println("- " + side);
            }
            System.out.println();
        
            if (!sides.get(0).equalsIgnoreCase("no side")) {
                hasSides = true;
            }
            extraSides = processExtraToppingInquiry(hasSides, "side(s)");
    
    
    
        int selectedOptionNum;
        do {
            System.out.println("Would you like the sandwich toasted? (Type 1 for \"Yes\" / Type 0 for \"No\")");
            selectedOptionNum = scanner.nextInt();
        
            switch (selectedOptionNum) {
                case 1:
                    isToasted = true;
                    System.out.println("\nYou selected \"Yes\"\n");
                    break;
                case 0:
                    System.out.println("\nYou selected \"No\"\n");
                    break;
                default:
                    System.out.println("\nERROR: Must type 1 or 0!\n");
                    break;
            }
        } while (selectedOptionNum != 1 && selectedOptionNum != 0);
    
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
    }
    
    public static void processAddDrinkRequest(Order order) {
        String[] drinkSizesArr = {"small", "medium", "large"};
        String[] flavorsArr = {
                "pineapple soda", "mango soda", "cherry soda", "strawberry soda",
                "blue raspberry soda", "coca-cola", "root beer", "dr. pepper", "mountain dew",
                "sprite", "lemonade", "strawberry lemonade"
        };
        String drinkSize;
        String flavor;
    
        System.out.println("\n\t~You chose the Add Drink option~\n");
    
    
        // • Add Drink - select drink size and flavor
        System.out.println("Select your drink size:");
            displayOptions(drinkSizesArr, "drink size");
        
            System.out.println("Please enter your selection here:");
            int selectedDrinkSizeNum = scanner.nextInt();
        
            drinkSize = optionSelection(drinkSizesArr, selectedDrinkSizeNum);
            if (drinkSize.equals("")) {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
        
            System.out.println("\nYou selected a \"" + drinkSize + "\" drink size.\n");
    
    
    
        System.out.println("Select a flavor:");
            displayOptions(flavorsArr, "flavor");
        
            System.out.println("Please enter your selection here:");
            int selectedFlavorNum = scanner.nextInt();
        
            flavor = optionSelection(flavorsArr, selectedFlavorNum);
            if (flavor.equals("")) {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
        
            System.out.println("\nYou selected the \"" + flavor + "\".\n");
    
        Drink drink = new Drink(drinkSize, flavor);
        System.out.println(drink);
    
        order.add(drink);
    }
    
    public static void processAddChipsRequest(Order order) {
        String[] chipTypeArr = {
                "flamin' hot cheetos (crunchy)", "flamin' hot cheetos (puffy)", "red doritos",
                "blue doritos", "potato chips", "bbq chips", "cheddar cheese chips",
                "sour cream & onion chips", "salt & vinegar chips", "takis", "hot fries"
        };
        String chipType;
    
        System.out.println("\n\t~You chose the Add Chips option~\n");
    
    
        System.out.println("Select your chip type:");
            displayOptions(chipTypeArr, "chip type");
        
            System.out.println("Please enter your selection here:");
            int selectedChipTypeNum = scanner.nextInt();
        
            chipType = optionSelection(chipTypeArr, selectedChipTypeNum);
            if (chipType.equals("")) {
                System.out.println("\nERROR: Not a valid option number.\n");
                return;
            }
        
            System.out.println("\nYou selected \"" + chipType + "\"\n");
    
        Chip chip = new Chip(chipType);
        System.out.println(chip);
    
        order.add(chip);
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
    
    public static void displayPreviousOptions(ArrayList<String> allOptions) {
        String lastOption = allOptions.get(allOptions.size() - 1);
        
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
    
    public static void displayUpdatedOptions(ArrayList<String> allOptions, int selectedOptionNum) {
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
        
        for (int i = 1; i < options.size()+1; i++) {
            if (selectedOptionNum == 1) {
                optionItem = options.get(0);
            } else if (selectedOptionNum == i+1) {
                optionItem = options.get(i);
            }
        }
        
        return optionItem;
    }
    
    public static ArrayList<String> multiOptionsSelection(String[] optionsArr, String optionType) {
        ArrayList<String> selectedOptionItems = new ArrayList<>();
        boolean wantsMoreOptions = false;
        boolean duplicateOptions = false;
        int selectedOptionNum = 0;
//        int previousSelectedOptionNum = 0;
        int additionalOptionNumChoice;
        int timesItemsAdded = 0;
        int count = 0;
        String selectedOptionItem = "";
    
        ArrayList<String> allOptions = new ArrayList<>(Arrays.asList(optionsArr)); // turns the array into an ArrayList/List
        String lastOption = allOptions.get(allOptions.size()-1);
        
        do {
            if (
                    (timesItemsAdded >= 0)
                            && (selectedOptionNum > 0)
                            && (selectedOptionNum < (allOptions.size() + 1))
            ) {
                System.out.println("Select " + optionType + "s:");
                displayUpdatedOptions(allOptions, selectedOptionNum);
            } else if ((count > 0) && (timesItemsAdded >= 0)) {
                System.out.println("Select " + optionType + "s:");
                displayPreviousOptions(allOptions);
            }
            count++;
            
            System.out.println("Enter your selection here:");
            selectedOptionNum = scanner.nextInt();
    
            if (selectedOptionNum > 0 && selectedOptionNum < (allOptions.size()+1)) {
                selectedOptionItem = optionSelection(allOptions, selectedOptionNum);
    
                if (!selectedOptionItem.equalsIgnoreCase(lastOption)) {
        
                    for (String alreadySelectedItem : selectedOptionItems) {
                        if (selectedOptionItem.equalsIgnoreCase(alreadySelectedItem)) {
                            duplicateOptions = true;
                            System.out.println("\nYou selected: " + alreadySelectedItem + "\n");
                            System.out.println("\nERROR: You have already added this " + optionType + "!\n");
                            break;
                        } else {
                            duplicateOptions = false;
                        }
                    }
                    if (!duplicateOptions) {
                        selectedOptionItems.add(selectedOptionItem);
                        System.out.println("\nYou selected: " + selectedOptionItem + "\n");
//                        previousSelectedOptionNum = selectedOptionNum;
                        ++timesItemsAdded;
                    }
                } else {
                    selectedOptionItems.clear();
                    selectedOptionItems.add(selectedOptionItem);
                    System.out.println("\n\tYou selected the \"" + selectedOptionItem + "\" option\n"); // the "no-" option
                    break;
                }
            } else {
                System.out.println("\nERROR: Must type a number that corresponds with an option listed! (e.g. 1)\n");
                wantsMoreOptions = true;
                continue;
            }
            
             do {
                System.out.println("Would you like to add another " + optionType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
                additionalOptionNumChoice = scanner.nextInt();
    
                switch (additionalOptionNumChoice) {
                    case 1:
                        wantsMoreOptions = true;
                        System.out.println("\nYou selected \"Yes\"\n");
                        break;
                    case 0:
                        wantsMoreOptions = false;
                        System.out.println("\nYou selected \"No\"\n");
                        break;
                    default:
                        System.out.println("\nERROR: Must type 1 or 0!\n");
                        break;
                }
            } while (additionalOptionNumChoice != 1 && additionalOptionNumChoice != 0);
//            else {
//                break;
//            }
        } while (wantsMoreOptions && timesItemsAdded < optionsArr.length-1);
        
        if (timesItemsAdded == optionsArr.length-1 && (wantsMoreOptions)) {
            System.out.println("\n\tYou cannot add another " + optionType + " as there are only " + (optionsArr.length-1) + " available.\n");
        }
        
        return selectedOptionItems;
    }
    
    public static boolean processExtraToppingInquiry(boolean hasTopping, String toppingType) {
        boolean extraToppingOption = false;
        
        int optionNumChoice = 0;
        if (hasTopping) do {
            System.out.println("Would you like (an) extra " + toppingType + "? (Type 1 for \"Yes\" / Type 0 for \"No\")");
            optionNumChoice = scanner.nextInt();
    
            switch (optionNumChoice) {
                case 1:
                    extraToppingOption = true;
                    System.out.println("\nYou selected \"Yes\"\n");
                    break;
                case 0:
                    System.out.println("\nYou selected \"No\"\n");
                    break;
                default:
                    System.out.println("\nERROR: Must type 1 or 0!\n");
                    break;
            }
        } while (optionNumChoice != 1 && optionNumChoice != 0);
        
        return extraToppingOption;
    }
    
    
    //  Might add a back button that you can press... at (almost) anytime. Might require a whole Generic Class
        // Step 1: Back button will be... 0!!!
    
}

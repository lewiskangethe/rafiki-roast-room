package com.rafikiroast.ui;

import com.rafikiroast.models.*;
import com.rafikiroast.util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public static void runMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("""
                    ********************
                    Welcome to
                    The Rafiki Roast Room
                    ********************
                    HOME SCREEN
                    1.) Create a new order
                    0.) Exit
                    ********************
                    
                    Please make your selection from the menu: 
                    """);
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    runOrderMenu();
                    break;
                case "0":
                    System.out.println("""
                            Thank you for visiting Rafiki Roast Room. Kwaheri!
                            Roast.Relax.Repeat
                            """);
                    running = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE. Please enter 1 or 0.");
            }
        }
    }

    public static void runOrderMenu() {
        Order order = new Order();
        boolean running = true;

        while (running) {
            System.out.println("""
                    ********************
                    The Rafiki Roast Room
                    ********************
                    ORDER
                    1.) Food
                    2.) Drinks
                    3.) Checkout
                    0.) Cancel Order
                    ********************
                    """);
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addItem(order);
                    break;
                case "2":
                    addDrink(order);
                    break;
                case "3":
                    System.out.println(order);
                    ReceiptWriter.saveReceipt(order);
                    running = false;
                    break;
                case "0":
                    System.out.println("""
                            Order cancelled. Thank you for dining with us!
                            Roast. Relax. Repeat
                            """);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1,2,3 or 0.");
            }
        }
    }

    public static void addItem(Order order) {
        System.out.println("********************");
        System.out.println("Select Base Option:");
        System.out.println("********************");
        System.out.println("1.) Coconut Pilau Rice");
        System.out.println("2.) Jollof Rice");
        System.out.println("3.) Ugali Scoops");
        System.out.println("4.) Chapati Wrap");
        System.out.println("5.) Sukuma Wiki(Mixed Greens)");
        System.out.println("6.) Injera Strips");

        String baseChoice = scanner.nextLine().trim();
        BaseOptions base;

        System.out.println("*********************");
        System.out.println("Select Size:");
        System.out.println("*********************");
        System.out.println("1.) Lunch ($8)");
        System.out.println("2.) Dinner ($10)");
        String sizeChoice = scanner.nextLine().trim();
        String size = sizeChoice.equals("1") ? "Lunch" : "Dinner";
        double price = size.equals("Lunch") ? 8.00 : 10.00;

        switch (baseChoice) {
            case "1":
                base = new BaseOptions("Coconut Pilau Rice", size, price);
                break;
            case "2":
                base = new BaseOptions("Jollof Rice", size, price);
                break;
            case "3":
                base = new BaseOptions("Ugali Scoops", size, price);
                break;
            case "4":
                base = new BaseOptions("Chapati Wrap", size, price);
                break;
            case "5":
                base = new BaseOptions("Sukuma Wiki", size, price);
                break;
            case "6":
                base = new BaseOptions("Injera Strips", size, price);
                break;
            default:
                System.out.println("Invalid choice, defaulting to Coconut Pilau Rice");
                base = new BaseOptions("Coconut Pilau Rice", size, price);
        }

        OrderItem item = new OrderItem(base);

        // PROTEINS
        System.out.println("********************");
        System.out.println("Add Proteins? (an upcharge will apply) (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            String[] proteinOptions = {"Peri Peri Chicken", "Nyama Choma", "Mshikaki Skewers", "Berbere Beef",
                    "Ginger-Lime Tilapia", "Coconut Curry Beans", "Red Lentil Stew"};
            for (int i = 0; i < proteinOptions.length; i++)
                System.out.println((i + 1) + ") " + proteinOptions[i] + " (+$2 lunch / +$3 dinner)");

            System.out.println("Enter numbers of proteins to add separated by commas (0 to skip): ");
            String input = scanner.nextLine().trim();
            if (!input.equals("0")) {
                String[] choices = input.split(",");
                for (String c : choices) {
                    int num = Integer.parseInt(c.trim());
                    if (num >= 1 && num <= proteinOptions.length) {
                        double proteinPrice = size.equals("Lunch") ? 2.0 : 3.0;
                        item.addProtein(new Proteins(proteinOptions[num - 1], proteinPrice));
                    }
                }
            }
        }

        // PREMIUM ADD-ONS
        System.out.println("********************");
        System.out.println("Add Premium Add-Ons? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            String[] premiumOptions = {"Swahili Cheese Blend", "Coconut Cream Drizzle", "Sesame Tahini Drizzle", "Avocado"};
            for (int i = 0; i < premiumOptions.length; i++)
                System.out.println((i + 1) + ") " + premiumOptions[i] + " (+$2 lunch / +$2.50 dinner)");

            System.out.println("Enter numbers of add-ons separated by commas (0 to skip): ");
            String input = scanner.nextLine().trim();
            if (!input.equals("0")) {
                String[] choices = input.split(",");
                for (String c : choices) {
                    int num = Integer.parseInt(c.trim());
                    if (num >= 1 && num <= premiumOptions.length) {
                        double premiumPrice = size.equals("Lunch") ? 2.0 : 2.5;
                        item.addPremiumAddon(new PremiumAddOns(premiumOptions[num - 1], premiumPrice));
                    }
                }
            }
        }

        // TOPPINGS
        System.out.println("********************");
        System.out.println("Add Toppings? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            String[] toppingOptions = {"Kachumbari", "Roasted Sweet Plantains", "Grilled Peppers",
                    "Caramelized Onions", "Sweet Corn & Coconut Mix", "Cabbage Slaw",
                    "Sauteed Spinach", "Jalapenos", "Mango Salsa", "Spiced Mushrooms",
                    "Pickled Carrots", "Tomato-Ginger Relish"};
            for (int i = 0; i < toppingOptions.length; i++)
                System.out.println((i + 1) + ") " + toppingOptions[i]);

            System.out.println("Enter numbers of toppings separated by commas (0 to skip): ");
            String input = scanner.nextLine().trim();
            if (!input.equals("0")) {
                String[] choices = input.split(",");
                for (String c : choices) {
                    int num = Integer.parseInt(c.trim());
                    if (num >= 1 && num <= toppingOptions.length) {
                        item.addTopping(new Toppings(toppingOptions[num - 1]));
                    }
                }
            }
        }

        // SAUCES
        System.out.println("********************");
        System.out.println("Add Sauces? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            String[] sauceOptions = {"Pili Pili", "Tamarind Chilli", "Harissa Mayo",
                    "Coconut Herb Sauce", "Mango-Lime Drizzle", "House Vinaigrette"};
            for (int i = 0; i < sauceOptions.length; i++)
                System.out.println((i + 1) + ") " + sauceOptions[i]);

            System.out.println("Enter numbers of sauces separated by commas (0 to skip): ");
            String input = scanner.nextLine().trim();
            if (!input.equals("0")) {
                String[] choices = input.split(",");
                for (String c : choices) {
                    int num = Integer.parseInt(c.trim());
                    if (num >= 1 && num <= sauceOptions.length) {
                        item.addSauce(new Sauces(sauceOptions[num - 1]));
                    }
                }
            }
        }

        // CUSTOMIZED OPTION
        System.out.println("********************");
        System.out.println("Would you like to customize this item? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            item.setCustomized(true);
        }

        order.addItem(item);
        System.out.println("********************");
        System.out.println("Item added to order!\n");
    }

    public static void addDrink(Order order) {
        System.out.println("********************");
        System.out.println("SELECT DRINK:");
        System.out.println("********************");
        String[] drinks = {"Kenyan Chai", "Ethiopian Coffee",
                "Stoney Tangawizi", "Passion Fruit Juice", "Date Milkshake"};
        for (int i = 0; i < drinks.length; i++)
            System.out.println((i + 1) + ") " + drinks[i]);

        System.out.println("Enter number of drink to add (default 1): ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice < 1 || choice > drinks.length) choice = 1;

        System.out.println("Select Size: 1) Small 2) Large");
        String sizeChoice = scanner.nextLine().trim();
        String size = sizeChoice.equals("1") ? "Small" : "Large";
        double price = size.equals("Small") ? 2.75 : 3.50;

        Drinks drink = new Drinks(drinks[choice - 1], size, price);
        order.addDrink(drink);

        System.out.println("********************");
        System.out.println("Drink added!\n");
    }
}

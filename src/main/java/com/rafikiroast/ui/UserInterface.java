package com.rafikiroast.ui;

import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runMainMenu();
    }

    public static void runMainMenu() {
        boolean running = true;

        while (running) {
            //display home screen
            System.out.println("""
                    ********************
                    Welocme to
                    The Rafiki Roast Room
                    ********************
                    HOME SCREEN
                    1.) Create a new order
                    0,) Exit
                    ********************
                    
                    Please make your selection from the menu: 
                    """);
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    runOrderMenu();
                    break;
                case "0":
                    System.out.println("Thank you for visiting Rafiki Roast Room. Kwaheri!");
                    running = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE. Please enter 1 or 2.");
            }
        }
    }

    public static void runOrderMenu() {

    }

}

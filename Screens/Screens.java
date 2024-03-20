package Screens;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Screens {
    public static final String title = """
        _______  __   __  _______  _______  ______       _______  _______  __   __  ___   __    _  _______ 
        |       ||  | |  ||       ||       ||    _ |     |       ||   _   ||  | |  ||   | |  |  | ||       |
        |  _____||  | |  ||    _  ||    ___||   | ||     |  _____||  |_|  ||  |_|  ||   | |   |_| ||    ___|
        | |_____ |  |_|  ||   |_| ||   |___ |   |_||_    | |_____ |       ||       ||   | |       ||   | __ 
        |_____  ||       ||    ___||    ___||    __  |   |_____  ||       ||       ||   | |  _    ||   ||  |
         _____| ||       ||   |    |   |___ |   |  | |    _____| ||   _   | |     | |   | | | |   ||   |_| |
        |_______||_______||___|    |_______||___|  |_|   |_______||__| |__|  |___|  |___| |_|  |__||_______|
            """;

    public static final String choice = "Enter your choice: ";

    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getChoice(int n) {
        Scanner input = new Scanner(System.in);
        int choice;
        try {
            choice = input.nextInt();
            while (choice < 1 || choice > n) {
                System.out.print("Invalid Choice! Please enter a valid choice: ");
                choice = input.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.print( "Invalid Input! Please enter a valid integer choice: ");
            input.nextLine();
            choice = getChoice(n); 
        }
        return choice;
    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (name.length() == 0){
            System.out.print("Invalid Input! Please enter a valid name: ");
            name = getString();
        }
        return name;
    }

    public static int getInt() {
        Scanner input = new Scanner(System.in);
        int number;
        try {
            number = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Invalid Input! Please enter a valid integer: ");
            input.nextLine();
            number = getInt();
        }
        return number;
    }

}

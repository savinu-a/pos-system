package Screens;

import java.util.Scanner;

import Bill.Bill;

public class LoginScreen extends Screens {
    final String getname = "Enter your name: ";
    final String getpassword = "Enter your password: ";
    final String options = "[1] New Bill\n[2] Pending Bill\n[3] Log Out\n";

    public void login() {
        System.out.println(Screens.title);
        System.out.print(getname);
        String name = getString();
        System.out.print(getpassword);
        String password = getString();
        Screens.clearScreen();
        System.out.println("Welcome " + name + "!");
        System.out.println(options);
        System.out.print(Screens.choice);
        int choice = getChoice(3);
        switch (choice) {
            case 1:
                BillScreen showBill = new BillScreen();
                showBill.billScreen();
                break;
            case 2:
                System.out.println("Pending Bill");
                break;
            case 3:
                Screens.clearScreen();
                MainScreen mainScreen = new MainScreen();
                mainScreen.mainScreen();
                break;
        }

    }
}

package Screens;

import java.util.ArrayList;
import java.util.Hashtable;

import utils.Utils;

public class MainScreen extends Screens{
    final String options = "[1] Login\n[2] Settings\n[3] Exit\n";
    Hashtable<String, ArrayList<Object>> cashiers = Utils.loadCashiers();

    // Main Screen of the System
    public void mainScreen() {
        System.out.println(Screens.title);
        System.out.println(options);
        System.out.print(Screens.choice);
        int choice = Screens.getChoice(3);
        switch (choice) {
            case 1:
                Screens.clearScreen();
                LoginScreen login = new LoginScreen();
                login.handleLogin(cashiers);
                break;
            case 2:
                Screens.clearScreen();
                SettingsScreen settings = new SettingsScreen();
                settings.settingsScreen();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}

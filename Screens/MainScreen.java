package Screens;


public class MainScreen extends Screens{
    final String options = "[1] Login\n[2] Settings\n[3] Exit\n";

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
                login.login();
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

package Screens;

public class SettingsScreen extends Screens {
    final String options = "[1] Change Branch Name\n[2] Go Back\n";

    public void settingsScreen() {
        System.out.println(Screens.title);
        System.out.println(options);
        System.out.print(Screens.choice);
        int choice = Screens.getChoice(2);
        switch (choice) {
            case 1:
                System.out.print("Enter your Branch name: ");
                String name = getString();
                System.out.println("Name changed to " + name);
                break;
            case 2:
                Screens.clearScreen();
                MainScreen mainScreen = new MainScreen();
                mainScreen.mainScreen();
                break;
        }
    }
    
}

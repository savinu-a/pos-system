package Screens;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import utils.Utils;
import Bill.Bill;

public class LoginScreen extends Screens {
    final String getID = "Enter your ID: ";
    final String getpassword = "Enter your password: ";
    final String options = "[1] New Bill\n[2] Pending Bill\n[3] Log Out\n";

    public void login() {
        System.out.println(Screens.title);
        Hashtable<String, ArrayList<Object>> cashiers = Utils.loadCashiers();
        handleLogin(cashiers);
    }

    // Login Screen
    public void handleLogin(Hashtable<String, ArrayList<Object>> cashiers){
        System.out.print(getID);
        String id = getString();

        if (cashiers.containsKey(id)){
            System.out.print(getpassword);
            String password = getString();
            ArrayList<Object> cashier = cashiers.get(id);

            if(cashier.get(1).equals(password)){
                String name = (String)cashier.get(0);
                
                System.out.println("Welcome " + name + "!");
                System.out.println(options);
                System.out.print(Screens.choice);
                int choice = getChoice(3);
                switch (choice) {
                    case 1:
                        CustomerScreen customerScreen = new CustomerScreen();
                        String customerName = customerScreen.customerScreen();
                        Bill bill = new Bill(name,customerName,Utils.getBranch());
                        BillScreen billScreen = new BillScreen();
                        billScreen.billScreen(bill);
                        break;
                    case 2:
                        File pendingFile = new File("pending.ser");
                        if (pendingFile.exists()) {
                            bill = (Bill) Utils.deserialize("pending.ser");
                            billScreen = new BillScreen();
                            billScreen.billScreen(bill);
                        } else {
                            System.out.println("No pending bills!");
                        }
                        break;
                    case 3:
                        Screens.clearScreen();
                        MainScreen mainScreen = new MainScreen();
                        mainScreen.mainScreen();
                        break;
                }
            }else{
                System.out.println("Invalid ID or Password\n");
                handleLogin(cashiers);
            }
        } else {
            System.out.println("Invalid ID\n");
            handleLogin(cashiers);
        }
    }
}
package Screens;

import java.util.ArrayList;
import java.util.Hashtable;

import Bill.Bill;
import utils.Utils;

public class BillScreen extends Screens{
    final String options = "[1] Add Items\n[2] Generate Bill\n[3] Set Bill as Pending\n[4] Go Back";
    Hashtable<String, ArrayList<Object>> items = Utils.loadItems();
    
    public void billScreen(Bill bill) {
        Hashtable<String, ArrayList<Object>> items = Utils.loadItems();

        System.out.println(options);
        System.out.print(Screens.choice);
        int choice = Screens.getChoice(3);
        switch (choice) {
            case 1:
                System.out.print("Enter the item code: ");
                String code = getString();
                ArrayList<Object> item = items.get(code);
                if (item == null) {
                    System.out.println("Item not found!");
                    break;
                }
                else {
                    System.out.println("Item Name: " + item.get(0));
                    System.out.print("Enter the quantity: ");
                    int quantity = getInt();
                    bill.addItem(code, item, quantity);
                    System.out.println("Item added to the bill!");
                    billScreen(bill);
                }
                break;
            case 2:
                bill.printBill(bill);
                break;
            case 3:
                Utils.serialize(bill,"pending.ser");
                System.out.println("Bill set as pending!");
                break;
            case 4:
                Screens.clearScreen();
                LoginScreen login = new LoginScreen();
                login.login();
                break;
        }
    }
    
}

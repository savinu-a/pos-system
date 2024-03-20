package Screens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import utils.Utils;

public class CustomerScreen {
    // enter customer's phone number if a customer is registered
    public String customerScreen() {
        System.out.println("Enter Customer's phone number: ");
        String phoneNumber = Screens.getString();
        Hashtable<String, String> customers = Utils.loadCustomers();
        ArrayList<Object> customer = new ArrayList<>(customers.values());
        if (customers.containsKey(phoneNumber)) {
            String name = customers.get(phoneNumber);
            System.out.println("Customer Name: " + name);
            return name;
        } else {
            System.out.println("Customer not found!");
            System.out.println("Enter Customer's name: ");
            String name = Screens.getString();
            return name;
        }
    }
}

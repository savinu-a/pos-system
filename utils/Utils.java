package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Utils {
    final static String ITEM_LIST_PATH = "db/itemList.txt";
    final static String CASHIER_LIST_PATH = "db/cashierList.txt";
    final static String CUSTOMER_LIST_PATH = "db/customerList.txt";
    
    public static Hashtable<String, ArrayList<Object>> loadItems() {
        Hashtable<String, ArrayList<Object>> items = new Hashtable<String, ArrayList<Object>>();

        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_LIST_PATH))) {
            br.readLine(); // Skip the first line
            String item;
            while ((item = br.readLine()) != null) {
                String[] values = item.split(",");

                String itemCode = values[0].trim();
                String itemName = values[1].trim();
                Integer unitSize = Integer.parseInt(values[2].trim());
                String unit = values[3].trim();
                Double price = Double.parseDouble(values[4].trim());
                Double discount = Double.parseDouble(values[5].trim());

                ArrayList<Object> itemDetails = new ArrayList<Object>();
                itemDetails.addAll(Arrays.asList(itemName, unitSize, unit, price, discount));

                items.put(itemCode, itemDetails);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;

    }

    public static Hashtable<String, ArrayList<Object>> loadCashiers() {
        Hashtable<String, ArrayList<Object>> cashiers = new Hashtable<String, ArrayList<Object>>();

        try (BufferedReader br = new BufferedReader(new FileReader(CASHIER_LIST_PATH))) {
            br.readLine(); // Skip the first line
            String cashier;
            while ((cashier = br.readLine()) != null) {
                String[] values = cashier.split(",");

                String cashierID = values[0].trim();
                String cashierName = values[1].trim();
                String password = values[2].trim();
                
                ArrayList<Object> cashierDetails = new ArrayList<Object>();
                cashierDetails.addAll(Arrays.asList(cashierName, password));

                cashiers.put(cashierID, cashierDetails);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cashiers;

    }

    public static Hashtable<String, String> loadCustomers() {
        Hashtable<String, String> customers = new Hashtable<String, String>();

        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_LIST_PATH))) {
            br.readLine(); // Skip the first line
            String customer;
            while ((customer = br.readLine()) != null) {
                String[] values = customer.split(",");

                String mobile = values[0].trim();
                String customerName = values[1].trim();

                customers.put(mobile, customerName);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;

    }
}
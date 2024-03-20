package utils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import Bill.Bill;

public class Utils {
    public static String branch;
    final static String ITEM_LIST_PATH = "db/itemList.txt";
    final static String CASHIER_LIST_PATH = "db/cashierList.txt";
    final static String CUSTOMER_LIST_PATH = "db/customerList.txt";
    final static String BRANCH_PATH = "db/branch.txt";

    // Load items from the file
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

    // Load cashiers from the file
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

    // Load customers from the file
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

    // Getters and Setters for Branch
    public static String getBranch() {
        try (BufferedReader br = new BufferedReader(new FileReader(BRANCH_PATH))) {
            branch = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return branch;
    }

    public static void setBranch(String branch) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter( BRANCH_PATH);
            fw.write(branch);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Serialize and Deserialize Bill
    public static void serialize(Bill bill, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(bill);
            System.out.println("The object has been serialized and saved in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Bill deserialize(String filename) {
        Bill bill = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            bill = (Bill) objectIn.readObject();
            System.out.println("The object has been deserialized from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bill;
    }

}
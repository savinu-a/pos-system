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
    final static String ITEM_LIST_PATH = "db/itemList.txt";
    
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
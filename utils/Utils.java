package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Utils {
    public static String branch;
    final static String ITEM_LIST_PATH = "db/itemList.txt";
    final static String BRANCH_PATH = "db/branch.txt";
    
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
}
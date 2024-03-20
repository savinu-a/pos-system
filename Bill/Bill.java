package Bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;




public class Bill {
    private String cashier;
    private String date;
    private String branch;
    private String time;
    private HashMap<String, ArrayList<Object>> items = new HashMap<String, ArrayList<Object>>();

    public Bill(String cashier, String branch) {
        this.date = new Date().toString();
    }
    public void addItem(String key, ArrayList<Object> value, Integer quantity) {

        value.add(quantity);
        double price = (double)value.get(3) * quantity;
        double discount = price * (double)value.get(4);
        value.add(price);
        value.add(discount);
        this.items.put(key, value);
    }

    public void removeItem(String key) {
        this.items.remove(key);
    }

    public double totalDiscount(){
        double total = 0;
        for (ArrayList<Object> value : this.items.values()) {
            total += (double)value.get(8);
                
            
        }
        return Math.round(total * 100.0) / 100.0;
    }
    
    public double totalAmount(){
        double total = 0;
        for (ArrayList<Object> value : this.items.values()) {
            total += (double)value.get(7);
                
            
        }
        return Math.round(total * 100.0) / 100.0;
    }

}
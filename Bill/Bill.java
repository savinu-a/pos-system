package Bill;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Views.Block;
import Views.Board;




public class Bill {
    private String cashier;
    private String date;
    private String branch;
    private String time;
    private HashMap<String, ArrayList<Object>> items = new HashMap<String, ArrayList<Object>>();

    public Bill(String cashier, String branch) {
        this.date = new Date().toString();
    }
    public String getBranch() {
        return this.branch;
    }
    public String getChashier() {
        return this.cashier;
    }
    public String getDate() {
        return this.date;
    }
    public ArrayList<Object> getItems() {
        return new ArrayList<Object>(this.items.values());
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
            total += (double)value.get(7);
                
            
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

    public void printBill(Bill bill) {
        Board board = new Board(120);

        // Title
        Block title = new Block(board, 105, 1, "Super Savings Supermarket");
        title.setDataAlign(Block.DATA_CENTER);
        title.allowGrid(false);
        board.setInitialBlock(title);

        Block branch = new Block(board, 105, 1, "Branch: " + bill.getBranch());
        branch.setDataAlign(Block.DATA_CENTER);
        title.setBelowBlock(branch);

        Block cashier = new Block(board, 105, 1, "Date: "+ bill.getDate()+"Cashier: " + bill.getChashier());
        cashier.setDataAlign(Block.DATA_CENTER);
        branch.setBelowBlock(cashier);

        Block itemColumn = new Block(board, 27, 1, "Item");
        Block quantityColumn = new Block(board, 25, 1, "Quantity");
        Block priceColumn = new Block(board, 25, 1, "Price");
        Block discountColumn = new Block(board, 25, 1, "Discount");
        
        cashier.setBelowBlock(itemColumn);
        itemColumn.setRightBlock(quantityColumn);
        quantityColumn.setRightBlock(priceColumn);
        priceColumn.setRightBlock(discountColumn);
        
        
        
        
        // Items
        ArrayList<Object> items = bill.getItems();
        for (Object item : items) {
            ArrayList<Object> itemDetails = (ArrayList<Object>) item;
            Block itemBlock = new Block(board, 27, 1, itemDetails.get(0).toString());
            Block quantityBlock = new Block(board, 25, 1, itemDetails.get(5).toString());
            Block priceBlock = new Block(board, 25, 1, itemDetails.get(6).toString());
            Block discountBlock = new Block(board, 25, 1, itemDetails.get(7).toString()); 
            itemColumn.setBelowBlock(itemBlock);
            itemBlock.setRightBlock(quantityBlock);
            quantityBlock.setRightBlock(priceBlock);
            priceBlock.setRightBlock(discountBlock); 
            itemColumn = itemBlock;                    
        }

        Block total = new Block(board, 105, 1, "Total: " + bill.totalAmount());
        itemColumn.setBelowBlock(total);
        Block discount = new Block(board, 105, 1, "Discount: " + bill.totalDiscount());
        total.setBelowBlock(discount);

        System.out.println(board.invalidate().build().getPreview());
    }
}
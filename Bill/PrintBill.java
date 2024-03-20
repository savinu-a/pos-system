package Bill;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Views.Block;
import Views.Board;

public class PrintBill {
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

        
        // Items
        ArrayList<Object> items = bill.getItems();
        for (Object item : items) {
            ArrayList<Object> itemDetails = (ArrayList<Object>) item;
            Block itemBlock = new Block(board, 20, 1, itemDetails.get(0).toString());
            Block quantityBlock = new Block(board, 20, 1, itemDetails.get(5).toString());
            Block priceBlock = new Block(board, 20, 1, itemDetails.get(6).toString());
            Block discountBlock = new Block(board, 20, 1, itemDetails.get(7).toString());            
            itemBlock.allowGrid(false);
            cashier.setBelowBlock(itemBlock);
            itemBlock.setRightBlock(quantityBlock);
            quantityBlock.setRightBlock(priceBlock);
            priceBlock.setRightBlock(discountBlock);
        }
    }
}

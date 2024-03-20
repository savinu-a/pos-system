import java.util.ArrayList;
import java.util.Hashtable;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<Object>> items = Utils.loadItems();
        items.forEach((key, value) -> System.out.println(key + ": " + value));
    }
    
}

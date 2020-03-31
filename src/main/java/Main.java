import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ListProduct listProduct = new ListProduct();
        listProduct.add("apple", "sad pridonya", 5);
        listProduct.add("orange", "7j", 6);
        listProduct.add("apple", "sad pridonya", 5);
        listProduct.add("orange", "7j", 6);
        listProduct.add("apple", "sad pridonya", 5);
        listProduct.add("orange", "7j", 6);
        listProduct.add("apple", "sad pridonya", 5);
        listProduct.add("orange", "7j", 6);

        System.out.println(listProduct.size());

        System.out.println(listProduct.get("apple", "sad pridonya"));

        listProduct.delete("apple", "sad pridonya",
                listProduct.get("apple", "sad pridonya"));

        System.out.println(listProduct.size());


    }
}

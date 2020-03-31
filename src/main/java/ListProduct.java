import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ListProduct  {
    private Product[] products;
    private int size;

    public ListProduct(){
        products = new Product[2];
        size = 0;
    }

    public void add(String name, String warehouse, int col){
        Product product = new Product(name, warehouse, col);
        if(products.length - 1 <= size){
            int newSize = products.length * products.length;
            Product[] newProducts = new Product[newSize];

            for (int i = 0; i < size; i++) {
                newProducts[i] = products[i];
            }
            products = newProducts;
        }
        products[size] = product;
        size++;
    }

    public List<String> get(String name){
        List<String> warehouses = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            if(products[i].getName().equals(name)){
                warehouses.add(products[i].getName());
            }
        }
        return warehouses;
    }

    public int get(String name, String warehouse){
        ListProduct findElements = new ListProduct();
        for (int i = 0; i <= size; i++) {
            if (products[i].getName().equals(name) &&
                    products[i].getWarehouse().equals(warehouse)) {
                return products[i].getCol();
            }
        }
        return -1;
    }

    public void delete(String name, String warehouse, int col){
        Product product = new Product(name, warehouse, col);
        Product[] newProducts = new Product[products.length];
        int i = 0;
        for(Product el : products){
            if(!product.equals(el) && el != null){
                newProducts[i] = el;
                i++;
            }
        }
        size = i;
        products = newProducts;
    }

    public int size(){
        return size;
    }

    private static class Product{
        private final String name;
        private final String warehouse;
        private final int col;

        public Product(String name, String warehouse, int col) {
            this.name = name;
            this.warehouse = warehouse;
            this.col = col;
        }

        public String getName() {
            return name;
        }

        public String getWarehouse() {
            return warehouse;
        }


        public int getCol() {
            return col;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", warehouse='" + warehouse + '\'' +
                    ", col=" + col +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return col == product.col &&
                    Objects.equals(name, product.name) &&
                    Objects.equals(warehouse, product.warehouse);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name)^Objects.hash(warehouse)^Objects.hashCode(col);
        }
    }
}

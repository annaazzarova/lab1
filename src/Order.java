import java.util.HashMap;
import java.util.Map;

public class Order {
    public Map<Product, Boolean> products = new HashMap<Product, Boolean>();

    public void addProduct(Product product) {
        this.products.put(product, Boolean.FALSE);
    }

    public Map<Product, Boolean> getProducts() {
        return this.products;
    }

    public int getCount() {
        return this.products.size();
    }
}

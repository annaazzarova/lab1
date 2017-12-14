import java.util.ArrayList;

public class Order {
    ArrayList<OrderItem> products;

    Order() {
        products = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        this.products.add(item);
    }
}

import java.util.ArrayList;

public class Order2 {
    protected ArrayList<OrderItem> basket;

    Order2()
    {
        this.basket = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrder()
    {
        return this.basket;
    }

    public void push(Product product)
    {
        this.basket.add(new OrderItem(product));
    }

    public float sum()
    {
        float sum = 0;
        for (OrderItem item: this.basket) {
            sum += item.getCost();
        }
        return sum;
    }
}

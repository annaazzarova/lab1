import java.util.ArrayList;

public class OrderCountDiscount extends AbstractDiscount{
    int count;
    ArrayList<Product> excludeProductsSet = new ArrayList<Product>();

    public OrderCountDiscount(int count, ArrayList<Product> excludeProductsSet, float discount) {
        super(discount);
        this.count = count;
        this.excludeProductsSet = excludeProductsSet;
    }

    public ArrayList<DiscountResult> calculate(Order2 order) {
        int count = 0;

        for (OrderItem item: order.getOrder()) {
            if (this.isItemExcluded(item)) {
                ++ count;
            }
        }

        if (count == this.count) {
            float total = order.sum();

            return new DiscountResult(this, new ArrayList<Product>(), total * this.discount);
        }

        return null;
    }

    protected boolean isItemExcluded(OrderItem item) {
        for (Product exclude: excludeProductsSet) {
            if (item.equals(exclude)) {
                return true;
            }
        }

        return false;
    }
}

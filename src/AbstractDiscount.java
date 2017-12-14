import java.util.ArrayList;

/**
 * Created by anna.azarova on 14.12.2017.
 */
public abstract class AbstractDiscount {
    protected float discount;

    public AbstractDiscount(float discount) {
        this.discount = discount;
    }

    public abstract ArrayList<DiscountResult> calculate(Order2 order);

    protected int findProduct(OrderItem product, ArrayList<OrderItem> products) {
        int i = 0;
        for(OrderItem item: products) {
            if (item.equals(product) && !item.getUsedDiscount()) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    public float getDiscount() {
        return this.discount;
    }
}

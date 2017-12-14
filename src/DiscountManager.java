import java.util.ArrayList;

/**
 * Created by anna.azarova on 14.12.2017.
 */
public class DiscountManager {
    ArrayList<AbstractDiscount> discounts;

    public DiscountManager() {
        this.discounts = new ArrayList<AbstractDiscount>();
    }

    public void add(AbstractDiscount discount) {
        this.discounts.add(discount);
    }

    public ArrayList<DiscountResult> getPossibleDiscounts(Order2 order) {

        ArrayList<DiscountResult> discounts = new ArrayList<DiscountResult>();
        for(AbstractDiscount discount: this.discounts) {
            DiscountResult result = discount.calculate(order);
            discounts.add(result);
        }

        return discounts;
    }
}

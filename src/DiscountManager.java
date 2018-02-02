import java.util.ArrayList;

public class DiscountManager {
    protected ArrayList<Discount> discounts = new ArrayList<Discount>();
    protected Order order;
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }
    
    public ArrayList<Discount> getDiscounts() {
        return this.discounts;
    }
    
    public float doDiscountCalculation() {
        float sum = 0;

        for (Discount discount:this.discounts) {
            discount.setOrder(this.order);
            sum += discount.doCalculation();
        }

        return sum;
    }
}

import java.util.ArrayList;

public class DiscountResult {
    AbstractDiscount discount;
    ArrayList<Product> products;
    float discountQty;
    public DiscountResult(AbstractDiscount discount, ArrayList<OrderItem> products, float discountQty)
    {
        this.discount = discount;
        this.products = products;
        this.discountQty = 0;
    }

    public AbstractDiscount getDiscount()
    {
        return this.discount;
    }

    public float getDiscountQty()
    {
        return this.discountQty;
    }
    public void setDiscountQty(float discountQty)
    {
        this.discountQty = discountQty;
    }
}

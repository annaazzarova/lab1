import java.util.ArrayList;

public class Calculator
{
    Order2 order;
    DiscountManager discountManager;
    public void setOrder(Order2 order)
    {
        this.order = order;

    public void setDiscountManager(DiscountManager discountManager)
    {
        this.discountManager = discountManager;
    }

    public float calculate()
    {
        float totalDiscount = 0;
        float totalSum = this.order.sum();
        ArrayList<AbstractDiscount> discounts = this.discountManager.getPossibleDiscounts(this.order);
        for (AbstractDiscount discount: discounts) {
            System.out.println(discount.getDiscount());
            totalDiscount += discount.getDiscountQty();
        }
        return totalSum - totalDiscount;
    }
}

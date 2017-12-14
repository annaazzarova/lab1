import java.util.ArrayList;

public class ConcreteDiscount extends AbstractDiscount{

    protected ArrayList<Product> productsSet;

    public ConcreteDiscount(ArrayList<Product> productsSet, float discount) {
        super(discount);
        this.productsSet = productsSet;
    }

    public ArrayList<DiscountResult> calculate(Order2 order) {
        ArrayList<DiscountResult> results = new ArrayList<DiscountResult>();
        do {
            DiscountResult result = this.findDiscount(order);
            if (result == null) {
                break;
            }
            results.add(result);
        } while(true);

        return results;
    }

     protected DiscountResult findDiscount(Order2 order) {
        float productsSum = 0;
        ArrayList<OrderItem> products = new ArrayList<OrderItem>();
        ArrayList<OrderItem> productsSet = order.getOrder();

        for (OrderItem item: productsSet) {
            int k = this.findProduct(item, productsSet);

            if (k == -1) {
                return null;
            }

            productsSet.get(k).setUsedDiscount(true);
            productsSum += productsSet.get(k).getCost();

            products.add(productsSet.get(k));

            productsSet.remove(k);
        }

        float qty = productsSum * this.discount;
        return new DiscountResult(this, products, qty);
    }
}

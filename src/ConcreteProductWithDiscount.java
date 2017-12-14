import java.util.ArrayList;

public class ConcreteProductWithDiscount extends AbstractDiscount{
    protected Product product;
    protected ArrayList<Product> productsSet;

    public ConcreteProductWithDiscount(Product product, ArrayList<Product> productsSet, float discount)
    {
        super(discount);
        this.product = product;
        this.productsSet = productsSet;
    }
    public ArrayList<DiscountResult> calculate(Order2 order)
    {
        ArrayList<DiscountResult> results = new ArrayList<DiscountResult>();
        do
        {
            DiscountResult result = this.findDiscount(order);
            if (result == null) {
                break;
            }
            results.add(result);
        } while(true);
        return results;
    }
    protected DiscountResult findDiscount(Order2 order)
    {
        ArrayList<OrderItem> products = new ArrayList<>();
        ArrayList<OrderItem> productsSet = order.getOrder();
        int k1 = this.findProduct(this.product, productsSet);
        int k2 = -2;
        if (k1 == -1) {
            return null;
        }
        for (Product item: this.productsSet) {
            k2 = this.findProduct(item, productsSet);
            if (k2 != -1) {
                break;
            }
        }

        if (k2 == -2) {
            return null;
        }
        productsSet.get(k1).setUsedDiscount(true);
        productsSet.get(k2).setUsedDiscount(true);
        products.add(productsSet.get(k1));
        products.add(productsSet.get(k2));
        productsSet.remove(k1);
        productsSet.remove(k2);
        float productsSum = (float) (productsSet.get(0).getCost() + productsSet.get(1).getCost());
        float qty = productsSum * this.discount;
        return new DiscountResult(this, products, qty);
    }
}

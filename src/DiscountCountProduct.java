import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DiscountCountProduct extends Discount {
    protected Map<Integer, Float> discountRule = new HashMap<Integer, Float>();
    protected ArrayList<Product> expectedProducts = new ArrayList<Product>();

    public void addExpectedProduct(Product product) {
        this.expectedProducts.add(product);
    }

    public void addDiscountRule(int count, float discount) {
        this.discountRule.put(count, 1 - discount / 100);
    }

    @Override
    public float doCalculation() {
        float sum = 0;
        int cnt = 0;
        Map<Product, Boolean> products = this.order.products;
        for (Product item : products.keySet()) {
            if (!this.expectedProducts.contains(item) && products.get(item) == Boolean.FALSE) {
                sum += item.getPrice();
                products.put(item, Boolean.TRUE);
                cnt++;
            }
        }
        if (discountRule.keySet().contains(cnt)) {
            sum *= discountRule.get(cnt);
        }

        return sum;
    }


}

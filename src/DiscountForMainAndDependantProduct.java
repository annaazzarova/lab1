import java.util.ArrayList;
import java.util.Map;

class DiscountForMainAndDependantProduct extends Discount{
    protected Product mainProduct = null;
    protected ArrayList<Product> dependentProducts = new ArrayList<Product>();

    public void setMainProduct(Product product) {
        this.mainProduct = product;
    }

    public void setDependentProduct(Product product) {
        dependentProducts.add(product);
    }

    @Override
    float doCalculation() {
        float sum = 0;
        boolean hasMainProduct = false;
        if (this.mainProduct != null || this.dependentProducts.size() == 0) {
            return sum;
        }

        Map<Product, Boolean> products = this.order.products;
        for (Product item : products.keySet()) {
            if (item == this.mainProduct) {
                hasMainProduct = true;
            }
        }

        if (!hasMainProduct) {
            return sum;
        }

        for (Product item : products.keySet()) {
            if (this.dependentProducts.contains(item) && products.get(item) == Boolean.FALSE) {
                sum += item.getPrice();
                products.put(item, Boolean.TRUE);
            }
        }

        return sum;
    }
}

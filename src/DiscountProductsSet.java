import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DiscountProductsSet extends Discount{
    protected ArrayList<Product> productsSet = new ArrayList<Product>();

    public void setProductsSet(ArrayList<Product> productsSet) {
        this.productsSet = productsSet;
    }

    public ArrayList<Product> getProductsSet() {
        return this.productsSet;
    }

    public float doRecursive(Map<Product, Boolean> productsOrder, float sum) {
        Map<Product, Boolean> discountProducts = new HashMap<Product, Boolean>();
        for (Product product: this.productsSet) {

            for (Product item : productsOrder.keySet()) {
                System.out.println("1: " + product.getName());
                System.out.println("2: " + item.getName());
                System.out.println("Val: " + productsOrder.get(item));
                if (!productsOrder.get(item) && product == item){
                    discountProducts.put(item, Boolean.FALSE);
                    break;
                }
            }
        }

        if (discountProducts.keySet().size() == this.productsSet.size()) {
            for (Product product: discountProducts.keySet()){
                discountProducts.put(product, Boolean.TRUE);
                sum += product.getPrice();
            }
            return this.doRecursive(productsOrder, sum);
        }

        return sum * this.getDiscount();
    }

    @Override
    float doCalculation() {
        float sum = 0;
        Map<Product, Boolean> productsOrder = this.order.products;
        sum = this.doRecursive(productsOrder, sum);
        return sum;
    }
}

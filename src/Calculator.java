import java.util.Map;

public class Calculator {
    protected Order order;
    protected DiscountManager discountManager;

    public void setOrder (Order order) {
        this.order = order;
    }

    public void setDiscountManager (DiscountManager discountManager) {
        this.discountManager = discountManager;
    }

    public float doCalculationWithoutDiscount(){
        float sum = 0;
        Map<Product, Boolean> orderProducts = this.order.getProducts();
        for (Product product:orderProducts.keySet()) {
            if (!orderProducts.get(product)) {
                sum += product.getPrice();
            }
        }

        return sum;
    }
    public float doCalculation() {
        float sum = 0;
        this.discountManager.setOrder(this.order);
        sum = this.discountManager.doDiscountCalculation();
        System.out.println("Discount: " + sum);
        sum += this.doCalculationWithoutDiscount();
        System.out.println(sum);
        return sum;
    }
}

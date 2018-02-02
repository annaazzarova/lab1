import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class DiscountForDate extends Discount{
    protected Map<String, Float> discountDateRule = new HashMap<String, Float>();
    public String currentDate =new SimpleDateFormat("yyyy-MM-dd").format(new Date());


    public void addDiscountDateRule(String date, float discount) {
        this.discountDateRule.put(date, 1 - discount / 100);
    }



    @Override
    float doCalculation() {
        float sum = 0;

        Map<Product, Boolean> products = this.order.products;
        for (Product item : products.keySet()) {
            if (products.get(item) == Boolean.FALSE) {
                sum += item.getPrice();
                products.put(item, Boolean.TRUE);
            }
        }

        if (this.discountDateRule.containsKey(this.currentDate)) {
            sum *= discountDateRule.get(this.currentDate);
        }

        return sum;
    }
}

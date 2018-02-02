import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {

        Product a = new Product("A", 100);
        Product b = new Product("B", 100);
        Product c = new Product("C", 100);
        Product d = new Product("D", 100);
        Product e = new Product("E", 100);
        Product f = new Product("F", 100);
        Product g = new Product("G", 100);
        Product h = new Product("H", 100);
        Product i = new Product("I", 100);
        Product j = new Product("J", 100);
        Product k = new Product("K", 100);
        Product l = new Product("L", 100);
        Product m = new Product("M", 100);

        Order order = new Order();
        /*order.addProduct(a);
        order.addProduct(b);
        order.addProduct(c);
        */
        order.addProduct(d);
        order.addProduct(e);
        order.addProduct(f);
        order.addProduct(g);
        order.addProduct(h);
        order.addProduct(i);
        /*order.addProduct(j);
        order.addProduct(k);
        order.addProduct(l);
        order.addProduct(m);*/

        DiscountProductsSet d1 = new DiscountProductsSet();
        ArrayList<Product> products1 = new ArrayList<Product>();
        products1.add(a);
        products1.add(b);
        d1.setProductsSet(products1);
        d1.setDiscount(10);

        DiscountProductsSet d2 = new DiscountProductsSet();
        ArrayList<Product> products2 = new ArrayList<Product>();
        products2.add(d);
        products2.add(e);
        d2.setProductsSet(products2);
        d2.setDiscount(5);

        DiscountProductsSet d3 = new DiscountProductsSet();
        ArrayList<Product> products3 = new ArrayList<Product>();
        products3.add(e);
        products3.add(f);
        products3.add(g);
        d3.setProductsSet(products3);
        d3.setDiscount(5);

        DiscountForMainAndDependantProduct d4 = new DiscountForMainAndDependantProduct();
        d4.setMainProduct(a);
        d4.setDependentProduct(k);
        d4.setDependentProduct(l);
        d4.setDependentProduct(m);
        d4.setDiscount(5);

        DiscountCountProduct d5 = new DiscountCountProduct();
        d5.addExpectedProduct(a);
        d5.addExpectedProduct(c);
        d5.addDiscountRule(3, 5);
        d5.addDiscountRule(4,10);
        d5.addDiscountRule(5, 20);

        DiscountForDate d0 = new DiscountForDate();
        d0.addDiscountDateRule("2018-02-01", 20);

        DiscountManager discountManager =new DiscountManager();
        //discountManager.addDiscount(d0);
        discountManager.addDiscount(d1);
        discountManager.addDiscount(d2);
        discountManager.addDiscount(d3);
        discountManager.addDiscount(d4);
        discountManager.addDiscount(d5);


        Calculator calculator = new Calculator();
        calculator.setOrder(order);
        calculator.setDiscountManager(discountManager);
        float amount = calculator.doCalculation();

        System.out.println(amount);
    }

}

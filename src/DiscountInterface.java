public abstract class DiscountInterface {
    double discount = 0;
    DiscountInterface(double discount) {
        this.discount = discount;
    }

    abstract double calculateDiscount(Order order);


}

public class OrderItem extends Product {

    Product product;
    double discount = 0;

    OrderItem(Product product) {
        super(product.getPrice(), product.getName());
        this.product = product;
        this.discount = 0;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}

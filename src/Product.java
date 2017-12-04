public class Product {
    String name;
    double discount;

    Product(String name) {
        this.name = name;
    }

    void setDiscount (double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}

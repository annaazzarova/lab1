public class Product {
    String name;
    double price;
    double discount;

    Product(double price, String name) {
        this.price = price;
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

    public double getPrice() {
        return price;
    }
}

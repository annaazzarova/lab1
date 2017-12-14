public class Product implements ProductInterface{
    String name;
    double price;

    Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() { return price; }
}

public class Product {
    String name;
    float price;
    float discount = 0;

    Product(float price, String name) {
        this.price = price;
        this.name = name;
    }

    void setDiscount (float discount) {

        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    public float getPrice() { return price; }

    public float getPriceWithDiscount() { return this.getPrice()*(1 - this.getDiscount()); }
}

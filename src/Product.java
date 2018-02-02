public class Product {
    protected String name;
    protected float price;

    Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName () {
        return this.name;
    }

    public float getPrice () {
        return this.price;
    }
}

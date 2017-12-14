public class OrderItem {
    Product product;

    protected boolean usedDiscount;

    OrderItem(Product $product)
    {
        this.product = product;
        this.usedDiscount = false;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Product getProduct()
    {
        return this.product;
    }
    public float getCost()
    {
        return (float) this.product.getPrice();
    }

    public void setUsedDiscount(boolean usedDiscount)
    {
        this.usedDiscount = usedDiscount;
    }

    public boolean getUsedDiscount()
    {
        return this.usedDiscount;
    }

}

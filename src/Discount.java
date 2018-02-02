abstract class Discount {
    protected float discount = 1;
    protected Order order;

    abstract float doCalculation();

    public void setDiscount(float discount) {
        this.discount = 1 - discount / 100;
    }

    public float getDiscount() {
        return this.discount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}

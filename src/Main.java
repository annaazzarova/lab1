public class Main {


    public static void main(String[] args) {
        //Order order = new Order(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "D", "E", "F", "G", "H", "I", "J", "K", "A", "B", "A", "B", "B", "C", "D", "E", "F", "G"});
        //Order order = new Order(new String[]{"A", "B", "M", "D", "F", "F", "G", "H", "I", "J", "E", "A", "B", "A", "B", "B", "C", "D", "E", "F", "G"});
        //Order order = new Order(new String[]{"G", "F", "F", "A", "A", "B", "E", "F", "G", "E", "E", "D"});
        Order order = new Order(new String[]{"A", "B", "C", "D", "D"});
        order.getTotalDiscount();
        order.getProductsDiscount();
    }
}

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Catalog currentCatalog = createCatalog();
        //Order order = new Order(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "D", "E", "F", "G", "H", "I", "J", "K", "A", "B", "A", "B", "B", "C", "D", "E", "F", "G"});
        //Order order = new Order(new String[]{"A", "B", "M", "D", "F", "F", "G", "H", "I", "J", "E", "A", "B", "A", "B", "B", "C", "D", "E", "F", "G"});
        //Order order = new Order(new String[]{"G", "F", "F", "A", "A", "B", "E", "F", "G", "E", "E", "D"});
        Order order = new Order(currentCatalog, new String[]{"A", "B", "C", "D", "D", "L", "M", "A"});
        System.out.println(order.getPrice());
        System.out.println(order.getTotalOrderPrice());
        order.getProducts();
    }

    public static Catalog createCatalog() {
        Map<String, Double> catalog = new HashMap<String, Double>();
        catalog.put("A", (double) 100);
        catalog.put("B", (double) 100);
        catalog.put("C", (double) 100);
        catalog.put("D", (double) 100);
        catalog.put("E", (double) 100);
        catalog.put("F", (double) 100);
        catalog.put("G", (double) 100);
        catalog.put("H", (double) 100);
        catalog.put("I", (double) 100);
        catalog.put("J", (double) 100);
        catalog.put("K", (double) 100);
        catalog.put("L", (double) 100);
        catalog.put("M", (double) 100);

        return new Catalog(catalog);
    }
}

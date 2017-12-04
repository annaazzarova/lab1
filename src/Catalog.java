import java.util.HashMap;
import java.util.Map;

public class Catalog {
    Map<String, Double> catalog = new HashMap<String, Double>();

    Catalog(Map<String, Double> catalog) {
        this.catalog = catalog;
    }

    double getPrice(String item) {
        return this.catalog.get(item);
    }
}

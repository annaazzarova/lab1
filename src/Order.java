import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    ArrayList<Product> products = new ArrayList<>();
    int size;

    public void getProductsDiscount(){
        for (Product item: products) {
            System.out.println(item.getName() + " " + item.getDiscount());
        }
    }

    Order(String[] products) {
        ArrayList<Product> productsResult = new ArrayList<>();
        for (String s: products) {
            productsResult.add(new Product(s));
        }
        this.size = productsResult.size();
        this.products = productsResult;
    }

    ArrayList<Product> getTotalDiscount() {
        ArrayList<Product> result = new ArrayList<>();
        discountForCoupleProducts("A", "B", 0.1);
        discountForCoupleProducts("D", "E", 0.05);
        checkRule3();
        checkRule4();
        if (this.size == 3){
            discountForAllOrder(0.05);
        }
        if (this.size == 4){
            discountForAllOrder(0.1);
        }
        if (this.size == 5){
            discountForAllOrder(0.2);
        }
        return  result;
    }

    void discountForCoupleProducts(String first, String second, double discountValue) {
        int i = 0;
        for (Product item: this.products) {
            for (int j = i + 1; j < this.products.size(); ++j) {
                if (item.discount == 0 && this.products.get(j).discount == 0) {
                    if ((item.name == first && this.products.get(j).name == second) || (item.name == second && this.products.get(j).name == first)) {
                        item.setDiscount(discountValue);
                        this.products.get(j).setDiscount(discountValue);
                    }
                }
            }
            ++i;
        }
    }


    void checkRule3() {

        ArrayList<String> efg = new ArrayList<String>();
        efg.add("E");
        efg.add("F");
        efg.add("G");
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Map<String, ArrayList<Integer>> triple = new HashMap<String, ArrayList<Integer>>();
        triple.put("E", new ArrayList<Integer>());
        triple.put("F", new ArrayList<Integer>());
        triple.put("G", new ArrayList<Integer>());
        int i = 0;
        for (Product item: this.products) {
            if (efg.contains(item.name) && item.discount == 0){
                temp.add(i);
                ArrayList<Integer> currentValue = triple.get(item.name);
                currentValue.add(i);
                triple.put(item.name, currentValue);
            }
            ++i;
        }

        int numberTriple = products.size();
        for (ArrayList<Integer> val: triple.values()){
            if (val.size() < numberTriple) {
                numberTriple = val.size();
            }
        }

        for (int j = 0; j < numberTriple; ++j){
            for (ArrayList<Integer> val: triple.values()) {
                products.get((val.get(j))).discount = 0.05;
            }
        }

    }

    void checkRule4() {

    }


    void discountForAllOrder(double discountValue) {
        for (Product item: products) {
            if(item.name != "A" && item.name != "C") {
                if (item.discount == 0) {
                    item.setDiscount(discountValue);
                }
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Pizza pizza;
    private String hamburger;
    private Drink drink;


    List<Product> productList = new ArrayList<>();

    public List<Product> getAll() {
        return productList;
    }

    public void addProduct(Pizza pizza, Drink drink) {
        productList.add(pizza);
        productList.add(drink);

    }

    public Order(Pizza pizza, String hamburger, Drink drink) {
        this.pizza = pizza;
        this.hamburger = hamburger;
        this.drink = drink;
    }

    public Order(List<Product> productListList) {
        this.productList = productListList;
    }
}

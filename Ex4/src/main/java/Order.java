import java.util.ArrayList;
import java.util.List;

public class Order {
    private Pizza pizza;
    private String hamburger;
    private Drink drink;


    List<ProductList> productListList = new ArrayList<ProductList>();

    public Order(Pizza pizza, String hamburger, Drink drink) {
        this.pizza = pizza;
        this.hamburger = hamburger;
        this.drink = drink;
    }

    public Order(List<ProductList> productListList) {
        this.productListList = productListList;
    }
}

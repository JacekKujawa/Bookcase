import java.util.Objects;

public class Pizza {
private String pizzaName;
private String pizzaSize;
    public Pizza(String pizzaName, String pizzaSize) {
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;

    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(pizzaName, pizza.pizzaName) && Objects.equals(pizzaSize, pizza.pizzaSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaName, pizzaSize);
    }
}

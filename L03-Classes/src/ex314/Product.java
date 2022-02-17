package ex314;

public class Product {

    private final String name;
    private double price;



    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public void reducePrice(double price) {
        this.price -= price;
    }
}

package Ex05;

public abstract class Product {
    private String name;
    private double price;
    private String description;
    private final int vatPercent = 25;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPriceWithoutVAT() {
        return price;
    }

    public double getPriceWithVAT(){
        return getPriceWithoutVAT() + getPriceWithoutVAT() * ((double)vatPercent/100);
    }
}

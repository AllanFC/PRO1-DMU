package model;

public class Service {
    private final String name;
    private final int price;

    Service(String name, int price) { // Package visible
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Pris: " + price + " Kr.";
    }
}

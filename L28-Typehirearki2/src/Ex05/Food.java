package Ex05;

import java.time.LocalDate;

public class Food extends Product {
    private LocalDate bestBefore;
    private final int vatPercent = 5;

    public Food(String name, double price, String description, LocalDate bestBefore) {
        super(name, price, description);
        this.bestBefore = bestBefore;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public int getVatPercent() {
        return vatPercent;
    }

    @Override
    public double getPriceWithVAT(){
        return super.getPriceWithoutVAT() + super.getPriceWithoutVAT() * ((double)vatPercent/100);
    }
}

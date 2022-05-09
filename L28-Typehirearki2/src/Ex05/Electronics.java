package Ex05;

public class Electronics extends Product {
    private double kWh;
    private final int vatPercent = 30;

    public Electronics(String name, double price, String description, double kWh) {
        super(name, price, description);
        this.kWh = kWh;
    }

    public double getkWh() {
        return kWh;
    }

    public int getVatPercent() {
        return vatPercent;
    }

    @Override
    public double getPriceWithVAT(){
        return super.getPriceWithoutVAT() + super.getPriceWithoutVAT() * ((double)vatPercent/100);
    }
}

package Ex05;

public class Liquor extends Product {
    private double alcoholPercent;
    private final int vatPercent;

    public Liquor(String name, double price, String description, double alcoholPercent) {
        super(name, price, description);
        this.alcoholPercent = alcoholPercent;
        if(price > 90){
            vatPercent = 120;
        }else{
            vatPercent = 80;
        }
    }

    @Override
    public double getPriceWithVAT(){
        return super.getPriceWithoutVAT() + super.getPriceWithoutVAT() * ((double)vatPercent/100);
    }
}

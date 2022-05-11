package Ex03;

public class PercentDiscount implements Discount {
    private int discountPercentage;

    public PercentDiscount(int discountPercentage){
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price){
        return price - price * ((double) discountPercentage / 100);
    }
}

package ex3student;

public class PercentDiscount extends Discount{
    private int discountPercentage;

    public PercentDiscount(int discountPercentage){
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price){
        return price - price / discountPercentage;
    }
}

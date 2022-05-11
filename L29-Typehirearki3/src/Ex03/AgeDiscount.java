package Ex03;

public class AgeDiscount implements Discount{
    private int age;

    public AgeDiscount(int age){
        this.age = age;
    }

    @Override
    public double getDiscount(double price){
        return price - price * ((double) age / 100);
    }
}

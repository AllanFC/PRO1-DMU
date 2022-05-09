package Ex04;

public class Square extends Figur{
    private int sideLength;

    public Square(int xPos, int yPos, int sideLength){
        super(xPos, yPos);
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        String str = String.format("Square %s side Length: %d", super.toString(), sideLength);
        return str;
    }
}

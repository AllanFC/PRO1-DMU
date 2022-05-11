package Ex04;

public class Rectangle extends shape {
    private int side1;
    private int side2;

    public Rectangle(int Xpos, int yPos, int side1, int side2) {
        super(Xpos, yPos);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        String str = String.format("Rectangle %s side 1: %d side 2: %d", super.toString(), side1, side2);
        return str;
    }
}

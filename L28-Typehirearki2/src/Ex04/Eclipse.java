package Ex04;

public class Eclipse extends Figur{
    private int radius1;
    private int radius2;

    public Eclipse(int Xpos, int yPos, int radius1, int radius2) {
        super(Xpos, yPos);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    @Override
    public double area() {
        return radius1 * radius2 * Math.PI;
    }

    @Override
    public String toString() {
        String str = String.format("Eclipse %s radius1: %d radius2: %d", super.toString(), radius1, radius2);
        return str;
    }
}

package Ex04;

public abstract class Figur {
    private int xPos;
    private int yPos;

    public Figur(int Xpos, int yPos){
        this.xPos = Xpos;
        this.yPos = yPos;
    }

    public abstract double area();

    public void movexPos(int movexPos) {
        this.xPos += xPos;
    }

    public void moveyPos(int moveyPos) {
        this.yPos += yPos;
    }

    @Override
    public String toString() {
        String s = String.format("(%d,%d)", xPos, yPos);
        return s;
    }
}

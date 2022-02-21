package ex316;

public class Bug {
    private int position;
    private boolean right = true;

    public Bug(int initialPos) {
        this.position = initialPos;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if(right){
            this.position += 1;
        } else {
            this.position -= 1;
        }
    }

    public void turn() {
        if(right) {
            right = false;
        } else {
            right = true;
        }
    }
}

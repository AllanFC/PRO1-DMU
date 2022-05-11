package Ex01;

public class Chili implements Measurable{
    private int scoville;

    public Chili(int scoville){
        this.scoville = scoville;
    }


    @Override
    public double getMeasure() {
        return scoville;
    }

}

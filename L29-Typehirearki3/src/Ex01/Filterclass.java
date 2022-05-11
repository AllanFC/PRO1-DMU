package Ex01;

public class Filterclass implements Filter{
    private double limit;

    public Filterclass(double limit){
        this.limit = limit;
    }

    @Override
    public boolean accept(Measurable x) {
        return x.getMeasure() > limit;
    }
}

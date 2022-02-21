package ex313;

public class Car {
    private final double kmL;

    private double gas;

    public Car(double kmL) {
        this.kmL = kmL;
    }

    public void addGas(double gas) {
        this.gas += gas;
    }

    public void drive(double km) {
        this.gas -= km / this.kmL;
    }

    public double getGas() {
        return gas;
    }
}

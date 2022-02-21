package ex313;

public class CarApp {
    public static void main(String[] args) {
        Car myCar = new Car(50);
        myCar.addGas(20);
        myCar.drive(100);
        System.out.println(myCar.getGas());
    }

}

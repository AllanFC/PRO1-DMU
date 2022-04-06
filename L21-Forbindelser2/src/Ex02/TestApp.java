package Ex02;

public class TestApp {
    public static void main(String[] args) {
        Car car1 = new Car("AB12 345", "2019");
        car1.setPricePerDay(150);
        Car car2 = new Car("CD67 890", "2020");
        car2.setPricePerDay(550);
        Rental rent1 = new Rental(1, "04/04/2022", 9);
        Rental rent2 = new Rental(2, "04/04/2022", 30);

        rent1.addCar(car1);
        rent2.addCar(car2);

        System.out.println(rent1.getPrice());
        System.out.println(rent2.getPrice());

        System.out.println("Car1 longest rental: " + car1.longestRental());
        System.out.println("Car2 longest rental: " + car2.longestRental());
    }
}

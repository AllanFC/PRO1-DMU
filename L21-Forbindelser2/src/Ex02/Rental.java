package Ex02;

import DemoBidir.asso_group0m_0mperson.Person;

import java.util.ArrayList;

public class Rental{
    private int no;
    private String date;
    private int days; // days of rental


    public Rental(int no, String date, int days){
        this.no = no;
        this.date = date;
        this.days = days;
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    /**
     *
     * Pre: skal have mindst en car/rental
     */
    public int getPrice(){
        return cars.get(cars.get(0).getRentals().indexOf(this)).getPricePerDay() * days;
    }

    // association 0..* ---- 0..*
    final ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    /** Pre: The person is not connected to this group. */
    public void addCar(Car car) {
        cars.add(car);
        car.rentals.add(this);
    }

    /** Pre: The person is connected to this group. */
    public void removePerson(Car car) {
        cars.remove(car);
        car.rentals.remove(this);
    }
}
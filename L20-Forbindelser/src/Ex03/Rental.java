package Ex03;

public class Rental{
    private int no;
    private String date;
    private int days; // days of rental
    private Car car;

    public Rental(int no, String date, int days){
        this.no = no;
        this.date = date;
        this.days = days;
        car = null;
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

    public void addCar(Car car){
        this.car = car;
    }

    public void removeCar(){
        car = null;
    }

    public int getPrice(){
        return car.getPricePerDay() * days;
    }
}
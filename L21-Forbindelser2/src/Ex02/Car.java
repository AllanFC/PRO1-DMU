package Ex02;

import java.util.ArrayList;

public class Car {
    private String no; //registration number
    private String year; //registration year
    private int pricePerDay;

    // association 0..* ---- 0..*
    final ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String no, String year){
        this.no = no;
        this.year = year;
        pricePerDay = 0;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }

    public ArrayList<Rental> getRentals(){
        return new ArrayList<>(rentals);
    }
}

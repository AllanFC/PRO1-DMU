package Ex03;

public class Car {
    private String no; //registration number
    private String year; //registration year
    private int pricePerDay;

    public Car(String no, String year){
        this.no = no;
        this.year = year; sdgsadfg
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
}

package Ex02.modul;


import java.util.ArrayList;

public class Seat {
    private int number;
    private final Area.AreaEnum area;
    final ArrayList<Reservation> reservations = new ArrayList<>(); //Package visible
    private int hourlyRate;

    public Seat(int number, Area.AreaEnum area){
        this.number = number;
        this.area = area;
        hourlyRate = 50;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double price(int hours){
        double price = 0;
        if(area == Area.AreaEnum.VIP){
            price = (1.25 * hourlyRate) * hours;
        } else if(area == Area.AreaEnum.Children) {
            price = (0.2 * hourlyRate - hourlyRate) * hours;
        } else if(area == Area.AreaEnum.Tournament){
            price = (1.1 * hourlyRate) * hours;
        } else {
            price = hourlyRate * hours;
        }
        return price;
    }
}

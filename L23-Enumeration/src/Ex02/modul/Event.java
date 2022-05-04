package Ex02.modul;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private String name;
    private boolean publicAccess;
    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public Event(String name, boolean publicAccess){
        this.name = name;
        this.publicAccess = publicAccess;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public int amountOfReservedSeats(){
        int sum = 0;
        for(Reservation e : reservations){
            sum += e.getSeats().size();
        }
        return sum;
    }


}

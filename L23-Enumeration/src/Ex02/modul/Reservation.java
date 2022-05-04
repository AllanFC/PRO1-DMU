package Ex02.modul;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime start;
    private LocalDateTime end;
    private final ArrayList<Seat> seats = new ArrayList<>();

    public Reservation(LocalDateTime start, LocalDateTime end){
        this.start = start;
        this.end = end;
    }

    public void addSeats(Seat seat){
        seats.add(seat);
        seat.reservations.add(this);
    }

    public void removeSeats(Seat seat){
        seat.reservations.remove(this);
        seats.remove(seat);
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}

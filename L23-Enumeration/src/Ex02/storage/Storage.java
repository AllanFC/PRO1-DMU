package Ex02.storage;

import Ex02.modul.Event;
import Ex02.modul.Reservation;
import Ex02.modul.Seat;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Event> events = new ArrayList<>();
    private static final ArrayList<Reservation> reservations = new ArrayList<>();
    private static final ArrayList<Seat> seats = new ArrayList<>();

    public static void storeEvent(Event event){
        events.add(event);
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void storeReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public static void storeSeat(Seat seat){
        seats.add(seat);
    }

    public static ArrayList<Seat> getSeats() {
        return seats;
    }

}

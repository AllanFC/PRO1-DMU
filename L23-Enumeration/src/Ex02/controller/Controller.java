package Ex02.controller;

import Ex02.modul.Area;
import Ex02.modul.Event;
import Ex02.modul.Reservation;
import Ex02.modul.Seat;
import Ex02.storage.Storage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    public static Event createEvent(String name, boolean publicAccess){
        Event event = new Event(name, publicAccess);
        Storage.storeEvent(event);
        return event;
    }

    public static ArrayList<Event> getEvents(){
        return Storage.getEvents();
    }

    /*----------------------------------------------------------------------------------*/

    public static Reservation createReservation(LocalDateTime start, LocalDateTime end){
        Reservation reservation = new Reservation(start, end);
        Storage.storeReservation(reservation);
        return reservation;
    }

    public static ArrayList<Reservation> getReservation(){
        return Storage.getReservations();
    }

    public static void addReservationToEvent(Reservation reservation, Event event){
        event.addReservation(reservation);
    }
    /*----------------------------------------------------------------------------------*/

    public static Seat createSeat(int number, Area.AreaEnum area){
        Seat seat = new Seat(number, area);
        Storage.storeSeat(seat);
        return seat;
    }

    public static ArrayList<Seat> getSeats(){
        return Storage.getSeats();
    }
}

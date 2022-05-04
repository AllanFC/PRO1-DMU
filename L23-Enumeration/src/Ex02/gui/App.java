package Ex02.gui;

import Ex02.controller.Controller;
import Ex02.modul.Area;
import Ex02.modul.Event;
import Ex02.modul.Reservation;
import Ex02.modul.Seat;
import com.sun.glass.ui.Application;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }
    public static void initStorage(){
        Event dota = Controller.createEvent("Dota 2 tournament", true);
        Event csgo = Controller.createEvent("CS GO tournament", false);

        Seat s1 = Controller.createSeat(1, Area.AreaEnum.Tournament);
        Seat s2 = Controller.createSeat(2, Area.AreaEnum.Tournament);
        Seat s3 = Controller.createSeat(3, Area.AreaEnum.Standard);
        Seat s4 = Controller.createSeat(4, Area.AreaEnum.Standard);
        Seat s5 = Controller.createSeat(5, Area.AreaEnum.Children);
        Seat s6 = Controller.createSeat(6, Area.AreaEnum.VIP);

        Reservation r1 = Controller.createReservation(LocalDateTime.of(2019,8,12,20,0),
                LocalDateTime.of(2019,8,12,23,0));
        r1.addSeats(s1);
        r1.addSeats(s2);
        Controller.addReservationToEvent(r1, dota);
        Reservation r2 = Controller.createReservation(LocalDateTime.of(2019,8,13,19,0),
                LocalDateTime.of(2019,8,14,6,0));
        r2.addSeats(s3);
        r2.addSeats(s4);
        Reservation r3 = Controller.createReservation(LocalDateTime.of(2019,8,14,19,0),
                LocalDateTime.of(2019,8,15,6,0));
        r3.addSeats(s6);
    }
}

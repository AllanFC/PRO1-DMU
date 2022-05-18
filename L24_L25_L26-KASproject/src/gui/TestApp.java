package gui;

import controller.Controller;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        initStorage();

    }

    public static void initStorage(){
        Conference conference = Controller.createConference("Hav og Himmel", 1500, "fantasivej 40",
                LocalDateTime.of(2022,4, 20, 4,20),
                LocalDateTime.of(2022, 4, 22, 6, 9));

        Excursion e1 = Controller.createExcursion(conference, "Egeskov",
                LocalDateTime.of(2022, 4, 20, 14,0), 75, false);
        Excursion e2 = Controller.createExcursion(conference, "Trapholt",
                LocalDateTime.of(2022, 4, 22, 14,0), 200, true);
        Excursion e3 = Controller.createExcursion(conference, "Odense",
                LocalDateTime.of(2022, 4, 21, 14,0), 125, true);

        Hotel h1 = Controller.createHotel("Den Hvide Svane", "fantasivej 34", 1050, 1250);
        Hotel h2 = Controller.createHotel("Høtel Phønix", "fantasivej 33", 700, 800);
        Hotel h3 = Controller.createHotel("Pension Tusindfryd", "fatasivej 32", 500, 600);

        Service s1 = Controller.createService("WIFI", 50, h1);
        Service s2 = Controller.createService("WIFI", 50, h2);
        Service s3 = Controller.createService("WIFI", 50, h3);
        Service s4 = Controller.createService("Bad", 50, h3);
        ArrayList<Service> services = new ArrayList<>();
        services.add(s1);

        Participant p1 = Controller.createParticipant("Finn Madsen", "fantasivej 35", "Fantasiland",
                "88888888", "", "");
        Registration r1 = Controller.createRegistration(p1, conference, LocalDate.of(2022, 4,20),
                LocalDate.of(2022,4,22), null);

        Participant p2 = Controller.createParticipant("Niels Petersen", "fantasivej 36", "Fantasiland",
                "88888889", "", "");
        Registration r2 = Controller.createRegistration(p2, conference, LocalDate.of(2022, 4,20),
                LocalDate.of(2022,4,22), h1);

        Participant p3 = Controller.createParticipant("Ulla Hansen", "fantasivej 37", "Fantasiland",
                "88888890", "", "");
        Registration r3 = Controller.createRegistration(p3, conference, LocalDate.of(2022, 4,20),
                LocalDate.of(2022,4,21), null);
        Companion c1 = Controller.CreateCompanion("Hans Hansen", r3);
        Controller.addCompanionToExcursion(c1, e3);

        Participant p4 = Controller.createParticipant("Peter Sommer", "fantasivej 38", "Fantasiland",
                "88888891", "Lounge", "");
        Registration r4 = Controller.createRegistration(p4, conference, LocalDate.of(2022, 4,20),
                LocalDate.of(2022,4,22), h1);
        Companion c2 = Controller.CreateCompanion("Mie Sommer", r4);
        Controller.addCompanionToExcursion(c2, e1);
        Controller.addCompanionToExcursion(c2, e2);
        Controller.addServicesToRegistration(r4, services);

        Participant p5 = Controller.createParticipant("Lone Jensen", "fantasivej 39", "Fantasiland",
                "88888892", "Matas", "88888893");
        Registration r5 = Controller.createRegistration(p5, conference, LocalDate.of(2022, 4,20),
                LocalDate.of(2022,4,22), h1);
        Companion c3 = Controller.CreateCompanion("Jan Madsen", r5);
        Controller.addCompanionToExcursion(c3, e1);
        Controller.addCompanionToExcursion(c3, e3);
        Controller.addServicesToRegistration(r5, services);
        Controller.registerSpeaker(r5);

        System.out.println(r1.totalPrice());
        System.out.println(r2.totalPrice());
        System.out.println(r3.totalPrice());
        System.out.println(r4.totalPrice());
        System.out.println(r5.totalPrice());

        System.out.println();
        Controller.printListOfParticipants(conference);
        Controller.printListOfExcursions(conference);
        Controller.printListOfHotels();
    }
}

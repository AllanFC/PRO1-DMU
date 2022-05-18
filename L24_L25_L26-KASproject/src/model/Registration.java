package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Registration {
    private final LocalDate arrivalDate;
    private final LocalDate departureDate;
    private boolean speaker;

    //association 0..* <---> 1 Participant
    private Participant participant;

    //composition 0..* <---> 1 Conference
    Conference conference; // OBS: package visible

    //composition 1 ---> 0..1 Companion
    private Companion companion; //Nullable

    //association 0..* ---> 0..1 Hotel
    private Hotel hotel; //Nullable

    //association 1 ---> 0..* Service
    private ArrayList<Service> services = new ArrayList<>(); //Can be empty


    Registration(Participant participant, Conference conference, LocalDate arrivalDate,
                        LocalDate departureDate, Hotel hotel){
        this.participant = participant;
        this.conference = conference;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.hotel = hotel;
    }

    public boolean isSpeaker() {
        return speaker;
    }

    public void setSpeaker(boolean speaker) {
        this.speaker = speaker;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Conference getConference() {
        return conference;
    }

    public Companion getCompanion() {
        return companion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Service> getServices() {
        return services;
    }


    public void setServices(ArrayList<Service> services){
        this.services.addAll(services);
    }

    /**
     * Returns the amount of days between arrivalDate and departureDate
     */
    public int getAttendanceDays(){
        return Period.between(arrivalDate, departureDate).getDays();
    }

    /**
     * Returns the created companion
     */
    public Companion createCompanion(String name) {
        Companion companion1 = new Companion(name);
        companion = companion1;
        return companion;
    }

    /**
     * Returns the total price for the entire conference
     * Note: If the participant is a speaker the price per day for the conference is 0
     */
    public int totalPrice() {
        int days = getAttendanceDays();
        int sum = 0;
        if(hotel != null) {
            int service = 0;
            for (Service e : services) {
                service += e.getPrice();
            }
            service *= days;
            sum += service;
            if (companion == null) {
                sum += hotel.getPriceSingle() * days;
            } else {
                sum += hotel.getPriceDouble() * days;
            }
        }
        if(companion != null){
            sum += companion.totalExcursionPrice();
        }
        if (!speaker) {
            sum += conference.getPrice() * (days + 1); //
        }
        return sum;
    }

}

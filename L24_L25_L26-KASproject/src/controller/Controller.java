package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    /**
     * Creates a conference and stores it in the Storage
     * pre: Price >= 0. Name = not empty
     */
    public static Conference createConference(String name, int price, String location, LocalDateTime startDate, LocalDateTime endDate) {
        Conference conference = new Conference(name, price, location, startDate, endDate);
        Storage.storeConferences(conference);
        return conference;
    }

    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    /**
     * Adds a hotel to a conference
     * Pre: Hotel and conference is not null
     */
    public static void addHotelToConference(Hotel hotel, Conference conference) {
        conference.addHotel(hotel);
    }

    // -----------------------------------------------------------------------------------

    /**
     * Returns the created excursion and adds it to Storage
     * pre: price >= 0. date must be within the date of the conference
     */
    public static Excursion createExcursion(Conference conference, String name, LocalDateTime date, int price, boolean lunch) {
        Excursion excursion = conference.createExcursion(name, date, price, lunch);
        Storage.storeExcursions(excursion);
        return excursion;
    }

    /**
     * Prints the list of excursions for a conference
     * Pre: conference cannot be null
     * Note: Used for testing only
     */
    public static void printListOfExcursions(Conference conference) {
        for (String e : conference.listOfExcursions()) {
            System.out.println(e);
        }
    }

    public static ArrayList<Excursion> getExcursionsOfConference(Conference conference) {
        return conference.getExcursion();
    }

    // -----------------------------------------------------------------------------------

    /**
     * Returns the created registration and stores it in Storage
     * Pre: hotel can be null. arrivalDate and departureDate within date of conference
     */
    public static Registration createRegistration(Participant participant, Conference conference, LocalDate arrivalDate,
                                                  LocalDate departureDate, Hotel hotel) {
        Registration registration = conference.createRegistration(participant, conference,
                arrivalDate, departureDate, hotel);
        Storage.storeRegistrations(registration);
        return registration;
    }

    /**
     * Sets the participant as a speaker
     * Pre: registration cannot be null
     */
    public static void registerSpeaker(Registration registration) {
        registration.setSpeaker(true);
    }

    /**
     * Returns the total price for this registration (including conference, hotel and excursion)
     * Pre: registration cannot be null
     */
    public static int totalPrice(Registration registration) {
        return registration.totalPrice();
    }


    // -----------------------------------------------------------------------------------

    /**
     * Returns created companion and adds to storage
     * pre: name cannot be empty. registration cannot be null.
     */
    public static Companion CreateCompanion(String name, Registration registration) {
        Companion companion = registration.createCompanion(name);
        Storage.storeCompanions(companion);
        return companion;
    }

    /**
     * Adds companion to excursion
     * Pre: companion cannot already be added to this excursion. companion cannot be null
     * excursion cannot be null
     */
    public static void addCompanionToExcursion(Companion companion, Excursion excursion) {
        companion.addExcursion(excursion);
    }

    // -----------------------------------------------------------------------------------

    /**
     * Returns created service and adds to storage
     * Pre: name cannot be empty. Price >= 0. hotel cannot be null
     */
    public static Service createService(String name, int price, Hotel hotel) {
        Service service = hotel.createService(name, price);
        Storage.storeServices(service);
        return service;
    }
    /**
     * Returns available services of the hotel
     * Pre: hotel cannot be null
     */
    public static ArrayList<Service> getServiceOfHotel(Hotel hotel) {
        return hotel.getServices();
    }

    /**
     * Adds service(s) of hotel to registration
     * Pre: registration cannot be null. services cannot be empty
     */
    public static void addServicesToRegistration(Registration registration, ArrayList<Service> services) {
        registration.setServices(services);
    }

    // -----------------------------------------------------------------------------------

    /**
     * Return created hotel and adds to Storage
     * Pre: priceSingle and priceDouble >= 0. Name cannot be empty. address cannot be empty
     */
    public static Hotel createHotel(String name, String address, int priceSingle, int priceDouble) {
        Hotel hotel = new Hotel(name, address, priceSingle, priceDouble);
        Storage.storeHotels(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();
    }

    /**
     * Returns an ArrayList of the hotels available for the conference
     * pre: conference cannot be null
     */
    public static ArrayList<Hotel> getHotelsOfConference(Conference conference) {
        return conference.getHotels();
    }

    /**
     * Returns an ArrayList of Strings with the information of the hotels in the system
     */
    public static ArrayList<String> listOfHotels() {
        ArrayList<String> hotels = new ArrayList<>();
        for (Hotel e : getHotels()) {
            hotels.add(e.hotelInformation());
        }
        return hotels;
    }

    /**
     * Returns an ArrayList of Strings with the information of the hotels for the conference
     * Pre: conference cannot be null
     */
    public static ArrayList<String> listOfHotelsForConference(Conference conference) {
        ArrayList<String> hotels = new ArrayList<>();
        for (Hotel e : conference.getHotels()) {
            hotels.add(e.hotelInformation());
        }
        return hotels;
    }

    /**
     * Prints the list of all the hotels in the system
     * Pre: a hotel must be created
     * Note: Used for testing only
     */
    public static void printListOfHotels() {
        for (String e : listOfHotels()) {
            System.out.println(e);
        }
    }

    // -----------------------------------------------------------------------------------

    /**
     * Returns the created participant and adds to Storage
     * name cannot be empty. corporation and corporationPhoneNr can be empty.
     */
    public static Participant createParticipant(String name, String address, String country, String phoneNr, String corporation, String corporationPhoneNr) {
        Participant participant = new Participant(name, address, country, phoneNr, corporation, corporationPhoneNr);
        Storage.storeParticipants(participant);
        return participant;
    }

    /**
     * Prints the list of participants for a conference
     * Pre: conference cannot be null
     * Note: Used for testing only
     */
    public static void printListOfParticipants(Conference conference) {
        for (String e : conference.listOfParticipants()) {
            System.out.println(e);
        }
    }
}

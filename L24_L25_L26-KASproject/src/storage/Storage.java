package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Participant> participants = new ArrayList<>();
    private static final ArrayList<Conference> conferences = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Excursion> excursions = new ArrayList<>();
    private static final ArrayList<Registration> registrations = new ArrayList<>();
    private static final ArrayList<Companion> companions = new ArrayList<>();
    private static final ArrayList<Service> services = new ArrayList<>();

// ----------------------------------------------------------------------------------
    public static ArrayList<Participant> getParticipants() {
        return participants;
    }

    public static void storeParticipants(Participant participant) {
        participants.add(participant);
    }
// ----------------------------------------------------------------------------------

    public static ArrayList<Conference> getConferences() {
        return conferences;
    }

    public static void storeConferences(Conference conference) {
        conferences.add(conference);
    }
// ----------------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public static void storeHotels(Hotel hotel) {
        hotels.add(hotel);
    }
// ---------------------------------------------------------------------------------

    public static ArrayList<Excursion> getExcursions() {
        return excursions;
    }

    public static void storeExcursions(Excursion excursion) {
        excursions.add(excursion);
    }
// ---------------------------------------------------------------------------------

    public static ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    public static void storeRegistrations(Registration registration) {
        registrations.add(registration);
    }
// ---------------------------------------------------------------------------------

    public static ArrayList<Companion> getCompanions() {
        return companions;
    }

    public static void storeCompanions(Companion companion) {
        companions.add(companion);
    }
// ---------------------------------------------------------------------------------

    public static ArrayList<Service> getServices() {
        return services;
    }

    public static void storeServices(Service service) {
        services.add(service);
    }
}

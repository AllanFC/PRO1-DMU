package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conference {
    private final String name;
    private final int price;
    private final String location;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    // association --> 0..* Excursion
    private final ArrayList<Excursion> excursions = new ArrayList<>();

    //association --> 0..* Participant
    private final ArrayList<Registration> registrations = new ArrayList<>();

    //association --0..* Hotel
    private final ArrayList<Hotel> hotels = new ArrayList<>();

    public Conference(String name, int price, String location, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     *
     * The hotel is not already connected to the Conference
     */
    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    /**
     *
     * Returns the formatted Start Date "dd-MM-yyyy HH:mm"
     */
    public String getStartDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = startDate.format(formatter);
        return formatDateTime;
    }
    /**
     * Returns the formatted End Date "dd-MM-yyyy HH:mm"
     */
    public String getEndDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = endDate.format(formatter);
        return formatDateTime;
    }

    public ArrayList<Excursion> getExcursion() {
        return new ArrayList<>(excursions);
    }

    public ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    @Override
    public String toString() {
        return name;
    }

    // ---------------------------------------------------------------------------------------------------------------------

    /**
     * Returns created registration
     * Pre: participant is not already registered to the conference.
     arrivalDate and departureDate must be within conference start to end date.
     * Note : Hotel is nullable
     */
    public Registration createRegistration(Participant participant, Conference conference, LocalDate arrivalDate,
                                   LocalDate departureDate, Hotel hotel) {
        Registration registration = new Registration(participant, conference, arrivalDate, departureDate, hotel);
        registrations.add(registration);
        registration.conference = this;
        return registration;
    }

    /**
     * Returns created excursion
     * pre: date must be within the scope of the conference dates
     */
    public Excursion createExcursion(String name, LocalDateTime date, int price, boolean lunch) {
        Excursion excursion = new Excursion(name,date,price,lunch);
        excursions.add(excursion);
        excursion.conference = this;
        return excursion;
    }
// ---------------------------------------------------------------------------------------------------------------------

    /**
     * Returns a list of the registration data of all the participants for the conference
     */
    public ArrayList<String> listOfParticipants(){
        ArrayList<String> listOfParticipants= new ArrayList<>();
        for(Registration e : registrations){
            StringBuilder str = new StringBuilder();
            if(e.getCompanion() != null){
                str.append(e.getParticipant().getName()).append(" with ").append(e.getCompanion().getName()).append("\n");
            } else{
                str.append(e.getParticipant().getName()).append("\n");
            }
            if(e.isSpeaker()){
                str.append("  Speaker: Yes\n");
            }
            str.append("  Tlf.: ").append(e.getParticipant().getPhoneNr()).append("\n");
            str.append("  Dage: ").append(e.getAttendanceDays()+1).append("\n");
            if(e.getHotel() != null){
                str.append("  Hotel: ").append(e.getHotel().toString()).append("\n");
                str.append("  Services: ").append(e.getServices().toString()).append("\n");
            }
            str.append("  Pris: ").append(e.totalPrice()).append("\n");
            listOfParticipants.add(str.toString());
        }
        return listOfParticipants;
    }

    /**
     * Returns a list of excursion for the conference
     */
    public ArrayList<String> listOfExcursions(){
        ArrayList<String> listOfExcursions = new ArrayList<>();
        for(Excursion e : excursions){
            String str = e.getName() + "\n" + "  Dato: " + e.getDateFormatted() + "\n" + "  Pris: " + e.getPrice() + " Kr\n";
            listOfExcursions.add(str);
        }
        return listOfExcursions;
    }
}

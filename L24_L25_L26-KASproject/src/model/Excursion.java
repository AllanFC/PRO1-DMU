package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Excursion {
    private final String name;
    private final LocalDateTime date;
    private final int price;
    private final boolean lunch;

    // composition --> 1 Conference
    Conference conference; // Package visible

    //association ---> 0..* Companion
    final ArrayList<Companion> companions = new ArrayList<>(); // Package visible

    Excursion(String name, LocalDateTime date, int price, boolean lunch){ // Package visible
        this.name = name;
        this.date = date;
        this.price = price;
        this.lunch = lunch;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the formatted Date "dd-MM-yyyy HH:mm"
     */
    public String getDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = date.format(formatter);
        return formatDateTime;
    }

    public int getPrice() {
        return price;
    }

    public Conference getConference() {
        return conference;
    }

    public ArrayList<Companion> companions() {
        return companions;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = date.format(formatter);
        return name + " Dato: " + formatDateTime + " Pris: " + price + " Kr.";
    }
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String code;
    private String description;
    private LocalDate date;
    private int hourlyRate;
    private int amountHours;

    private ArrayList<Vagt> shifts = new ArrayList<>();

    Job(String code, String description, LocalDate date, int hourlyRate, int amountHours) {
        this.code = code;
        this.description = description;
        this.date = date;
        this.hourlyRate = hourlyRate;
        this.amountHours = amountHours;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getAmountHours() {
        return amountHours;
    }

    public ArrayList<Vagt> getShifts() {
        return shifts;
    }

    public Vagt createShift(int hours, Frivillig volunteer){
        Vagt shift = new Vagt(hours, volunteer);
        shifts.add(shift);
        shift.job = this;
        return shift;
    }

    public int ikkeBesatteTimer(){
        int sum = amountHours;
        for(Vagt e : shifts){
            if(e.getVolunteer() != null){
                sum -= e.getHours();
            }
        }
        return sum;
    }
}

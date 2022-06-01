package model;

public class Vagt {
    private int hours;
    Job job;
    private Frivillig volunteer;

    Vagt(int hours, Frivillig volunteer) {
        this.hours = hours;
        this.volunteer = volunteer;
    }

    public int getHours() {
        return hours;
    }

    public Frivillig getVolunteer() {
        return volunteer;
    }



}

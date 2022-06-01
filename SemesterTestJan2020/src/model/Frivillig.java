package model;

import java.util.ArrayList;

public class Frivillig {
    private String name;
    private String phoneNumber;
    private int maxHours;
    ArrayList<Vagt> shifts = new ArrayList<>();



    public Frivillig(String name, String phoneNumber, int maxHours) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.maxHours = maxHours;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public int ledigeTimer(){
        int sum = getMaxHours();
        for(Vagt e : shifts){
            sum -= e.getHours();
        }
        return sum;
    }

    public void assignFestival(Festival festival){
        festival.volunteers.add(this);
    }

}

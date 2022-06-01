package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Festival {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private ArrayList<Job> jobs = new ArrayList<>();

    ArrayList<Frivillig> volunteers = new ArrayList<>();

    public Festival(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Job createJob(String code, String description, LocalDate date, int hourlyRate, int amountHours){
        Job job = new Job(code,description,date,hourlyRate,amountHours);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift(){
        int sum = 0;
        for(Job e : jobs){
            sum += e.getAmountHours() * e.getHourlyRate();
        }
        return sum;
    }

    public int realiseretJobUdgift(){
        int sum = 0;
        for(Job e : jobs){
            for(Vagt element : e.getShifts()){
                sum += element.getHours() * e.getHourlyRate();
            }
        }
        return sum;
    }


    public ArrayList<String> gaverTilFrivillige(){
        ArrayList<String> gifts = new ArrayList<>();
        String str;
        for(Frivillig e : volunteers){
            if(e instanceof FrivilligForening){
                str = String.format("%-25s %-5d %25s", e.getName(), ((FrivilligForening) e).getAmountPeople(), ((FrivilligForening) e).getAssociationName());
            } else{
                str = String.format("%-25s 1",e.getName());
            }
            gifts.add(str);
        }
        Collections.sort(gifts);
        return gifts;
    }
}

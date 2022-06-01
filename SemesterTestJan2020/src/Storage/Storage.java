package Storage;

import model.Festival;
import model.Frivillig;
import model.Job;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Festival> festivaler = new ArrayList<>();
    private static final ArrayList<Frivillig> volunteers = new ArrayList<>();
    private static final ArrayList<Job> jobs = new ArrayList<>();

    public static void storeFestival(Festival festival){
        festivaler.add(festival);
    }

    public static void storeVolunteers(Frivillig volunteer){
        volunteers.add(volunteer);
    }
    public static void storeJob(Job job){
        jobs.add(job);
    }

    public static ArrayList<Festival> getFestivaler() {
        return festivaler;
    }

    public static ArrayList<Frivillig> getVolunteers() {
        return volunteers;
    }
    public static ArrayList<Job> getJobs(){
        return jobs;
    }
}

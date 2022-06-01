package Controller;

import Storage.Storage;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Festival createFestival(String name, LocalDate startDate, LocalDate endDate){
        Festival festival = new Festival(name, startDate, endDate);
        Storage.storeFestival(festival);
        return festival;
    }

    public static Frivillig createVolunteer(String name, String phoneNumber, int maxHours){
        Frivillig volunteer = new Frivillig(name, phoneNumber, maxHours);

        Storage.storeVolunteers(volunteer);
        return volunteer;
    }

    public static FrivilligForening createVolunteerAssociation(String name, String phoneNumber,
                                           int maxHours, String associationName, int amountPeople){
        FrivilligForening volunteerAssociation = new FrivilligForening(name, phoneNumber, maxHours,
                associationName, amountPeople);
        Storage.storeVolunteers(volunteerAssociation);
        return volunteerAssociation;
    }

    public static void assignFestival(Festival festival, Frivillig volunteer){
        volunteer.assignFestival(festival);
    }

    public static void initStorage(){
        Festival f1 = createFestival("Northside", LocalDate.of(2020,6,4),LocalDate.of(2020,6,6));
        Frivillig v1 = createVolunteer("Jane Jensen", "12345677", 20);
        Frivillig v2 = createVolunteer("Lone Hansen", "78787878", 25);
        Frivillig v3 = createVolunteer("Anders Mikkelsen", "55555555", 10);
        Frivillig va1 = createVolunteerAssociation("Cristian Madsen", "23232323", 100, "Erhversakadami Aarhus", 40);
        assignFestival(f1, v1);
        assignFestival(f1, v2);
        assignFestival(f1, v3);
        assignFestival(f1, va1);

        for (int i = 1; i <= 9; i++) {
            Job job = null;
            if(i <= 3){
                job = f1.createJob("T"+i,"Rengøring af toilet.", LocalDate.of(2022,6,4), 100,5);
                Storage.storeJob(job);
            } else if(i <= 6){
                f1.createJob("T"+i,"Rengøring af toilet.", LocalDate.of(2022,6,5), 100,5);
                Storage.storeJob(job);
            } else {
                f1.createJob("T"+i,"Rengøring af toilet.", LocalDate.of(2022,6,6), 100,5);
                Storage.storeJob(job);
            }
        }
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) throws RuntimeException{
        Vagt shift = null;
        if(job.ikkeBesatteTimer() >= timer && frivillig.ledigeTimer() >= timer){
            shift = job.createShift(timer, frivillig);
        } else {
            throw new RuntimeException("Den frivilige har ikke nok timer eller jobbet er for kort til den angivet tid");
        }
        return shift;
    }

    public static boolean findFrivillig(Festival festival, String navn) {
        boolean found = false;
        ArrayList<String> list = festival.gaverTilFrivillige();

        int left = 0;
        int right = list.size() - 1;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            String k = list.get(middle).substring(0, list.get(middle).lastIndexOf(" ", 25)).trim();
            if (k.equals(navn)) {
                found = true;
            } else if (k.compareTo(navn) > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return found;
    }

    public static ArrayList<String> getVolunteerGiftList(Festival festival){
        return festival.gaverTilFrivillige();
    }
}

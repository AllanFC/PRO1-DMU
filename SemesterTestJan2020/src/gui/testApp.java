package gui;

import Controller.Controller;
import Storage.Storage;
import model.Frivillig;

public class testApp {
    public static void main(String[] args) {
        Controller.initStorage();
        Frivillig v1 = Storage.getVolunteers().get(2);
        Controller.tagVagt(Storage.getJobs().get(0), v1, 5);
        for(String e : Controller.getVolunteerGiftList(Storage.getFestivaler().get(0))){
            System.out.println(e);
        }
        System.out.println(Storage.getFestivaler().get(0).budgetteretJobUdgift());
        System.out.println(Storage.getFestivaler().get(0).realiseretJobUdgift());
        System.out.println(Controller.findFrivillig(Storage.getFestivaler().get(0), "Anders Miksen"));
    }
}

package model;

import java.util.ArrayList;

public class Hotel {
    private final String name;
    private final String address;
    private final int priceSingle;
    private final int priceDouble;
    // association --> 0..* Service
    private final ArrayList<Service> services = new ArrayList<>();

    // association --> 0..* Participant
    private final ArrayList<Participant> participants = new ArrayList<>();

    public Hotel(String name, String address, int priceSingle, int priceDouble) {
        this.name = name;
        this.address = address;
        this.priceSingle = priceSingle;
        this.priceDouble = priceDouble;
    }

    public int getPriceDouble() {
        return priceDouble;
    }

    public int getPriceSingle() {
        return priceSingle;
    }

    //------------------------------------------------------------------------------------------------


    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    /**
     * Returns the created service
     * Note: if price is 0 service is included in Hotel price
     */
    public Service createService(String name, int price) {
        Service service = new Service(name, price);
        services.add(service);
        return service;
    }

    /**
     * Returns a String of the hotel information
     */
    public String hotelInformation(){
        StringBuilder str = new StringBuilder();
        if(services.size() > 1){
            str.append(name + "\n" + "  Single room: " + priceSingle + "Kr \n" +
                    "  Double room: " + priceDouble + "Kr \n" + "  Service: ");
            for (int i = 0; i < services.size(); i++) {
                if(i != services.size() - 1){
                    str.append(services.get(i).getName()).append(" ").append(services.get(i).getPrice()).append("Kr").append(", ");
                } else {
                    str.append(services.get(i).getName()).append(" ").append(services.get(i).getPrice()).append("Kr\n");
                }
            }
        } else if(services.size() == 1) {
            str.append(name + "\n" + "  Single room: " + priceSingle + "Kr \n" +
                    "  Double room: " + priceDouble + "Kr \n" + "  Service: " + services.get(0).getName() + " " + services.get(0).getPrice() + "Kr\n");
        } else{
            str.append(name + "\n" + "  Single room: " + priceSingle + "Kr \n" +
                    "  Double room: " + priceDouble + "Kr \n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}

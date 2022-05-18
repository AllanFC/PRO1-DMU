package model;

public class Participant {
    private final String name;
    private final String address;
    private final String country;
    private final String phoneNr;
    private final String corporation;
    private final String corporationPhoneNr;



    public Participant(String name, String address, String country, String phoneNr, String corporation, String corporationPhoneNr) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneNr = phoneNr;
        this.corporation = corporation;
        this.corporationPhoneNr = corporationPhoneNr;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }
}

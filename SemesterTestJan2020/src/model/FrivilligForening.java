package model;

public class FrivilligForening extends Frivillig{
    private String associationName;
    private int amountPeople;

    public FrivilligForening(String name, String phoneNumber, int maxHours, String associationName, int amountPeople) {
        super(name, phoneNumber, maxHours);
        this.associationName = associationName;
        this.amountPeople = amountPeople;
    }

    public String getAssociationName() {
        return associationName;
    }

    public int getAmountPeople() {
        return amountPeople;
    }
}

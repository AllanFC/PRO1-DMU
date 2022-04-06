package Ex03;

public class Gift {
    private String description;
    private double price;
    private Person giver;
    private Person receiver;

    public Gift(String description, double price, Person giver){
        this.description = description;
        this.price = price;
        this.giver = giver;
        giver.giftsGiven.add(this);
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * Pre: This does not have another receiver
     */
    public void addReceiver(Person receiver) {
        this.receiver = receiver;
        receiver.giftsReceived.add(this);
    }

    public Person getGiver() {
        return giver;
    }
}

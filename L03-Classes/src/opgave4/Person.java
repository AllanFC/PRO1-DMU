package opgave4;

public class Person {

    private final String name;

    private String address;

    private int monthlySalery;
    private double yearlySalery;

    public Person(String name, String address, int monthlySalery){
        this.name = name;
        this.address = address;
        this.monthlySalery = monthlySalery;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonthlySalery() {
        return this.monthlySalery;
    }

    public void setMonthlySalery(int monthlySalery) {
        this.monthlySalery = monthlySalery;
    }

    public double calcyearlySalery() {
        this.yearlySalery = (this.monthlySalery * 12) * 1.025;

        return this.yearlySalery;
    }

    public void printPerson() {
        System.out.println("*************************");
        System.out.println("* " + this.name);
        System.out.println("* " + this.address);
        System.out.println("* " + this.monthlySalery + "Kr.");
        System.out.println("*************************");
    }


}

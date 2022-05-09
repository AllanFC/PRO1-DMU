package Ex03;

public class Mechanic extends Employee {
    private String graduationMechanic;
    public Mechanic(String name, String address, String graduationMechanic, int hourlyRate){
        super(name, address, hourlyRate);
        this.graduationMechanic = graduationMechanic;
    }
}

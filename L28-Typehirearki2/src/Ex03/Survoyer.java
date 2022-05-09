package Ex03;

public class Survoyer extends Mechanic {
    private int inspections;

    public Survoyer(String name, String address, String graduationMechanic, int hourlyRate){
        super(name, address, graduationMechanic, hourlyRate);
        inspections = 5;
    }

    public void performInspection(){
        this.inspections++;
    }

    @Override
    public double weeklySalary(){
        return super.weeklySalary() + (inspections * 29);
    }
}

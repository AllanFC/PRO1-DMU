package Ex01;

public class Survoyer extends Mechanic{
    private int inspections;

    public Survoyer(String name, String address, String graduation, double hourlyRate){
        super(name, address, graduation, hourlyRate);
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

package Ex03;

public class Foreman extends Employee {
    private String graduationMechanic;
    private String graduationForeman;
    private int bonus;

    public Foreman(String name, String address, String graduationMechanic, int hourlyRate, String graduationForeman, int bonus){
        super(name, address, hourlyRate);
        this.graduationMechanic = graduationMechanic;
        this.graduationForeman = graduationForeman;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public double weeklySalary(){
        return super.weeklySalary() + bonus;
    }

}

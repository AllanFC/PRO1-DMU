package Ex01;

import java.util.ArrayList;

public class Foreman extends Mechanic{
    private String graduation;
    private int bonus;

    public Foreman(String name, String address, String graduationMechanic, int hourlyRate, String graduationForeman, int bonus){
        super(name, address, graduationMechanic, hourlyRate);
        this.graduation = graduationForeman;
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

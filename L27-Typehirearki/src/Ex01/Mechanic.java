package Ex01;

import java.util.ArrayList;

public class Mechanic extends Person{
    private String graduation;
    private double hourlyRate;

    public Mechanic(String name, String address, String graduation, double hourlyRate){
        super(name, address);
        this.graduation = graduation;
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double weeklySalary(){
        return hourlyRate * 37;
    }
}

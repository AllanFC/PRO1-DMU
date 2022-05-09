package Ex03;

public class WorkingBoy extends Employee{

    public WorkingBoy (String name, String address, int hourlyRate){
        super(name, address, hourlyRate);
    }

    @Override
    public double weeklySalary(){
        return super.getHourlyRate() * 25;
    }

}

package Ex03;

public abstract class Employee {
    private String name;
    private String address;
    private int hourlyRate;



    public Employee(String name, String address, int hourlyRate){
        this.name = name;
        this.address = address;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public double weeklySalary(){
        return hourlyRate * 37;
    }
}

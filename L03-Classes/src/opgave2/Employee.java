package opgave2;

public class Employee {
    // The name of the employee.
    private final String firstName;
    private final String lastName;
    // Whether the employee is a trainee or not.
    private boolean trainee;

    private int age;

    /**
     * Create an employee as a trainee with the given name.
     */
    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainee = true;
        this.age = age;
    }

    /**
     * Return the name of the employee.
     */
    public String getName() {
        return this.firstName + " " + this.lastName;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    /**
     * Return the trainee state of the employee.
     */
    public boolean isTrainee() {
        return trainee;
    }

    /**
     * Set the trainee state of the employee.
     */
    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    /**
     * Return a description of the employee (for test purposes).
     */
    @Override
    public String toString() {
        return firstName + " (trainee: " + trainee + ")";
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public void birthday() {
        this.age += 1;
    }

    /**
     * Print a description of the employee.
     */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Trainee: " + this.trainee);
        System.out.println("Age: " + this.age);
        System.out.println("*******************");
    }
}

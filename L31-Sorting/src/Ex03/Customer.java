package Ex03;

public class Customer implements Comparable<Customer>{
    private String firstName;
    private String lastName;
    private int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  "" + firstName + " " + lastName;
    }

    @Override
    public int compareTo(Customer c) {
        int biggest;
        if(lastName.compareTo(c.getLastName()) == 0){
            if(firstName.compareTo(c.getFirstName()) == 0){
                biggest = age - c.getAge();
            }else{
                biggest = firstName.compareTo(c.getFirstName());
            }
        }else {
            biggest = lastName.compareTo(c.getLastName());
        }
        return biggest;
    }
}

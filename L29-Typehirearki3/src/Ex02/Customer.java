package Ex02;

public class Customer implements Compareable{
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
    public Customer compareTo(Customer x) {
        if(lastName.compareTo(x.getLastName()) < 0){
            return x;
        } else if (lastName.compareTo(x.getLastName()) > 0) {
            return this;
        }
        if(firstName.compareTo(x.getFirstName()) < 0){
            return x;
        }else if (firstName.compareTo(x.getFirstName()) > 0) {
            return this;
        }
        if(age < x.getAge()){
            return x;
        } else if(age > x.getAge()){
            return this;
        }
        return this;
    }

    @Override
    public String toString() {
        return  "" + firstName + " " + lastName + " " + age;
    }
}

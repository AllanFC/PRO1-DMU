package Ex01;

import java.util.ArrayList;

public class Person {
    private String name;
    private String cpr;
    private String phone;

    public Person(String name, String cpr, String phone){
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /*--------------------------------------------*/
    final ArrayList<Dog> dogs = new ArrayList<>();

    /** Pre: The dog is not connected to a person. */
    public void addDog(Dog dog) {
        dogs.add(dog);
        dog.person = this;
    }

    /** Pre: The dog is connected to this person. */
    public void removeDog(Dog dog) {
        dogs.remove(dog);
        dog.person = null;
    }

    public ArrayList<Dog> getDogs(){
        return dogs;
    }
}

package Ex1d;

public class Dog {
    private int number;
    private String name;

    //association person 0..1 ----- 0..* dog
    private Person person; // package visible

    public Dog(int number, String name){
        this.number = number;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    /** Pre: The dog is not connected to a person. */
    public void addPerson(Person person) {
        person.dogs.add(this);
        this.person = person;
    }

    /** Pre: The dog is connected to this person. */
    public void removePerson(Person person) {
        person.dogs.remove(this);
        this.person = null;
    }
}

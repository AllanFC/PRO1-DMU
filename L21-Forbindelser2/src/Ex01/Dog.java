package Ex01;

public class Dog {
    private int number;
    private String name;

    //association person 0..1 ----- 0..* dog
    Person person; // package visible

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
}

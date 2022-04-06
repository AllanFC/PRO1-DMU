package Ex03;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    final ArrayList<Gift> giftsReceived = new ArrayList<>();
    final ArrayList<Gift> giftsGiven = new ArrayList<>();

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public double valueOfGifts(){
        double sum = 0;
        for(Gift e : giftsReceived){
            sum += e.getPrice();
        }
        return sum;
    }

    public ArrayList<Person> giftsReceivedFrom(){
        ArrayList<Person> givers = new ArrayList<>();
        for(Gift e : giftsReceived){
            givers.add(e.getGiver());
        }
        return givers;
    }
}

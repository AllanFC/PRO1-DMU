package Ex1d;

public class App {
    public static void main(String[] args) {
        Dog d1 = new Dog(1, "Fiddo");
        Dog d2 = new Dog(2, "Max");

        Person p1 = new Person("Eric", "123113-3233", "88888888");
        Person p2 = new Person("Mad", "151151-1515", "93939393");

        d1.addPerson(p1);
        d2.addPerson(p1);

        System.out.println(p1.getName() + " " + p1.getDogs().toString());
        System.out.println(p2.getName() + " " + p2.getDogs().toString());

        d2.removePerson(p1);
        d2.addPerson(p2);

        System.out.println(p1.getName() + " " + p1.getDogs().toString());
        System.out.println(p2.getName() + " " + p2.getDogs().toString());
    }
}

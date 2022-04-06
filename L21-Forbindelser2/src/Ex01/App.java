package Ex01;

public class App {
    public static void main(String[] args) {
        Dog d1 = new Dog(1, "Fiddo");
        Dog d2 = new Dog(2, "Max");

        Person p1 = new Person("Eric", "123113-3233", "88888888");
        Person p2 = new Person("Mad", "151151-1515", "93939393");

        p1.addDog(d1);
        p1.addDog(d2);

        System.out.println(p1.getName() + " " + p1.getDogs().toString());
        System.out.println(p2.getName() + " " + p2.getDogs().toString());

        p1.removeDog(d2);
        p2.addDog(d2);

        System.out.println(p1.getName() + " " + p1.getDogs().toString());
        System.out.println(p2.getName() + " " + p2.getDogs().toString());
    }
}

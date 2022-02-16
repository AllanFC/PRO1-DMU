package opgave4;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Hans Andersen", "fantasivej 3, 9999 fantasiby", 36000);
        p1.printPerson();
        System.out.println("Yearly salery: " + p1.calcyearlySalery());

    }
}

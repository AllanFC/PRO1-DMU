package opgave2;


public class PersonTester {

    public static void main(String[] args) {
        opgave2.Person p1 = new opgave2.Person("Ib", 2000, 10, 6);
        p1.printPerson();

        System.out.println(p1.leapYear(2066));

    }
}

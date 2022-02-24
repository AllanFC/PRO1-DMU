package opgave2;


import java.util.Scanner;

public class PersonTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        opgave2.Person p1 = new opgave2.Person("Ib", 2000, 10, 6);
        p1.printPerson();
        //System.out.println(p1.leapYear(2066));
        System.out.println("Input year month day");
        System.out.println(p1.calcage(sc.nextInt(), sc.nextInt(), sc.nextInt()));



    }
}

package ex516;

import java.util.Scanner;

public class CardApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Card mycard = new Card(sc.next());

        System.out.println(mycard.getDescription());

        sc.close();
    }
}

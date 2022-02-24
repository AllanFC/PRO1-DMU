package ex516;

import java.util.Scanner;

public class CardApp {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card notation = new Card(sc.next());
        notation.getDescription();


    sc.close();
    }
}

import java.util.Scanner;

public class ex507 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sc1 = in.nextInt();
        int sc2 = in.nextInt();
        int sc3 = in.nextInt();

        if(sc1 > sc2 && sc2 > sc3) {
            System.out.printf("%d %d %d is in decending order", sc1, sc2, sc3);
        } else if(sc1 < sc2 && sc2 < sc3) {
            System.out.printf("%d %d %d is in increasing order", sc1, sc2, sc3);
        } else {
            System.out.println("The order of the integers are neither increasing nor decreasing");
        }

        in.close();
    }
}

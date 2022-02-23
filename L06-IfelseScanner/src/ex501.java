import java.util.Scanner;

public class ex501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Write an integer here: ");
        int input = in.nextInt();

        if(input > 0) {
            System.out.println(input + " Is a positive integer");
        } else if(input < 0) {
            System.out.println(input + " Is a negative integer");
        } else {
            System.out.println("You inputted " + input);
        }
    }
}

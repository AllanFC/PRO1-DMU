import java.util.Scanner;

public class Ex3App {
    public static void main(String[] args) {
        int sum = 0;
        int a, b;
        System.out.println("Enter 2 odd numbers");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();

        if(a % 2 != 0 && b % 2 != 0) {
            for(int i = a; i <= b; i += 2){
                sum += i;
            }
            System.out.printf("Sum of odd numbers between %d and %d is: " + sum, a, b);
        } else {
            System.out.println("One of the 2 numbers entered is not odd");
        }

    }
}

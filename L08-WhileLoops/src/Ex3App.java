import java.util.Scanner;

public class Ex3App {
    public static void main(String[] args) {
        int sum = 0;
        int a, b;
        boolean odd;
        System.out.println("Enter 2 numbers");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();

        if(a % 2 != 0) {
            odd = true;
        } else {
            a++;
        }
        for(int i = a; i <= b; i += 2){
            sum += i;
        }
        System.out.printf("Sum of odd numbers between %d and %d is: " + sum, a, b);


    }
}

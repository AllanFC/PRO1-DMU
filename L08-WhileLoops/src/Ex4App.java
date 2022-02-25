import java.util.Scanner;

public class Ex4App {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();

        for(int i = 0; i <= input.length()-1; i++){
            int value = Character.getNumericValue(input.charAt(i));
            if(value % 2 != 0){
                sum += value;
            }

        }
        System.out.println(sum);
    }
}

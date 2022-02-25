public class Ex2App {
    public static void main(String[] args) {
        int sum = 0;

        for(int i = 2; i <= 100; i += 2){
            sum += i;
        }
        System.out.println(sum);

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("");

        sum = 0;
        for(int i = 1; i <= 100; i++){
            sum += Math.pow(i, 2);
        }
        System.out.println(sum);

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("");

        for(int i = 0; i <= 20; i++){
            System.out.println(Math.pow(2, i));
        }
    }
}

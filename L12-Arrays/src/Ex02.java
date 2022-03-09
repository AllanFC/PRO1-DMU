public class Ex02 {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println(sumArrays(array));
    }

    public static int sumArrays(int[] t){
        int sum = 0;
        for(int e : t){
            sum += e;
        }
        return sum;
    }
}

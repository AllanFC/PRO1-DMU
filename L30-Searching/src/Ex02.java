public class Ex02 {
    public static void main(String[] args) {
        int[] numbers = {2,4,68,44,8,10,6,4};

        System.out.println(intevalSearch(numbers, 10,15));
    }

    public static boolean intevalSearch(int[] array, int min, int max){
        boolean betweenInteval = false;
        int i = 0;
        while(!betweenInteval && i < array.length){
            int k = array[i];
            if(k >= min && k <= max){
                betweenInteval = true;
            }else{
                i++;
            }
        }
        return betweenInteval;
    }
}

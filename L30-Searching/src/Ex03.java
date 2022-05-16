public class Ex03 {
    public static void main(String[] args) {
        int[] numbers = {2,4,68,44,8,8,8,8,8,8,8,8,8,8};

        System.out.println(adjecentSearch(numbers, 10));
    }

    public static boolean adjecentSearch(int[] array, int times){
        boolean adjecentCountReached = false;
        int i = 0;
        int counter = 1;
        while(!adjecentCountReached && i < array.length - 1){
            int k = array[i];
            int j = array[i+1];
            if(k == j){
                counter++;
                i++;
                if(counter == times){
                    adjecentCountReached = true;
                }
            }else{
                counter = 1;
                i++;
            }
        }
        return adjecentCountReached;
    }
}

public class Ex07 {
    public static void main(String[] args) {
        int[] ints = {4,6,1,-7,10,-3,6};
        System.out.println(searchSum(ints, -6));
    }

    public static int searchSum(int[] t, int total){
        int index = -1;
        int i = 0;
        while(index == -1 && i < t.length){
            if(sumUp(t, i, total)){
                index = i;
            } else{
                i++;
            }
        }
        return index;
    }

    public static boolean sumUp(int[] list, int index, int totalSum){
        boolean found = false;
        int j = 0;
        int tempSum = 0;
        while(!found && j < list.length - index){
            tempSum += list[index+j];
            if(tempSum == totalSum){
                found = true;
            }else{
                j++;
            }
        }
        return found;
    }
}

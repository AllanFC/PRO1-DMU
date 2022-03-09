

public class Ex04 {
    public static void main(String[] args) {
        int[] a = {4,6,7,2,3};
        System.out.println(hasUneven(a));
        int[] b = {4,6,8,2,6};
        System.out.println(hasUneven(b));

}

    public static boolean hasUneven(int[] t){
        boolean odd = false;
        for(int e : t){
            if(e % 2 != 0){
                odd = true;
            }
        }
        return odd;
    }
}

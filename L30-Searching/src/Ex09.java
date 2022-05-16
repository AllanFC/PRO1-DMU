public class Ex09 {
    public static void main(String[] args) {
        int[] test = {0, 2, 3, 4, 7, 8, 9, 10, 111};

        for (Integer e : test) {
            System.out.print(binaryRoots(e) + " ");
        }
        System.out.println();
        for (Integer e : test) {
            System.out.print(linearRoots(e) + " ");
        }

    }

    public static int linearRoots(int n){
        int highest = -1;
        int i = 0;
        while (highest == -1 && i <= n) {
            int k = i;
            if (k * k <= n && n < (k + 1) * (k + 1))
                highest = k;
            else
                i++;
        }
        return highest;
    }

    public static int binaryRoots(int n){
        int highest = -1;
        int left = 0;
        int right = n;
        while (highest == -1 && left <= right) {
            int middle = (left + right) / 2;
            if (middle * middle <= n && n < (middle+1) * (middle+1))
                highest = middle;
            else if (middle * middle > n)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return highest;
    }
}

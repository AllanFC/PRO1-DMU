public class Ex06 {
    public static void main(String[] args) {
        String str = "zzgkvvmmmmm";
        System.out.println(repeatedChars(str, 6));
    }

    public static boolean repeatedChars(String s, int k){
        boolean found = false;
        int i = 0;
        while(!found && i <= s.length() - k){
            if(match(s, i, k)){
                found = true;
            } else{
                i++;
            }
        }
        return found;
    }

    public static boolean match(String string, int index, int occurrence){
        boolean foundDiff = false;
        int j = 1;
        while(!foundDiff && j <= occurrence - 1){
            if(string.charAt(index) != string.charAt(index + j)){
                foundDiff = true;
            }else{
                j++;
            }
        }
        return !foundDiff;
    }

//    public static boolean repeatedChars(String s, int k){
//        boolean found = false;
//        int i = 0;
//        int counter = 1;
//        while(!found && i < s.length() - 1){
//            int l = s.charAt(i);
//            int j = s.charAt(i+1);
//            if(l == j){
//                counter++;
//                i++;
//                if(counter == k){
//                    found = true;
//                }
//            }else{
//                counter = 1;
//                i++;
//            }
//        }
//        return found;
//    }
}

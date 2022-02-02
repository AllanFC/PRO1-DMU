public class E104 {
    public static void main(String[] args) {
        float j = 1000;
        System.out.println(j + "$");
        for (int i = 0; i < 3; i++) {
            j *= 1.05;
            System.out.println(j + "$");
        }
    }
}

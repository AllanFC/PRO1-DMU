public class ex03 {
    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        //a
        System.out.println(ord1.toUpperCase());

        //b
        System.out.println(ord2.toLowerCase());

        //c
        System.out.println(ord1 + " " + ord2);

        //d
        String ord3 = ord1 + ord2.toLowerCase();
        System.out.println(ord3);

        //e
        System.out.println(ord3.length());

        //f
        System.out.println(ord1.substring(0, 7));

        //g
        System.out.println(ord2.substring(3, 8));

        //h
        System.out.println(ord3.substring(ord3.length()/2));




    }
}

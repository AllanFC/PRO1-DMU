package opgave2;

public class opgave2App {
    public static void main(String[] args) {
        opgave2 girl = new opgave2(3, false);
        opgave2 boy = new opgave2(18, true);

        System.out.println(girl.gender());
        System.out.println(girl.institution());
        System.out.println(girl.team());

        System.out.println(boy.gender());
        System.out.println(boy.institution());
        System.out.println(boy.team());

    }
}

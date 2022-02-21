public class ex04app {
    public static void main(String[] args) {
        ex04 name1 = new ex04("Allan", "Christiansen");
        System.out.println(name1.getFullName());
        System.out.println(name1.getUsername());
        System.out.println(name1.getInits());
        System.out.println(name1.getCryptoInits(2));

        ex04 name2 = new ex04("Allan", "Fogsgaard", "Christiansen");
        System.out.println(name2.getFullName());
        System.out.println(name2.getUsername());
        System.out.println(name2.getInits());
        System.out.println(name2.getCryptoInits(2));


    }
}

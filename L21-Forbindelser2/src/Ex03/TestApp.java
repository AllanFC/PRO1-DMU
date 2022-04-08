package Ex03;

public class TestApp {
    public static void main(String[] args) {
        Person p1 = new Person("Mad Max", 21);
        Person p2 = new Person("Dandylion", 22);

        Gift g1 = new Gift("Sweater", 200.0, p1);
        p2.addReceiver(g1);
        Gift g2 = new Gift("Socks", 30.0, p1);
        p2.addReceiver(g2);

        System.out.println(p1.getName() + " Received gifts from: " + p1.giftsReceivedFrom());
        System.out.println(p2.getName() + " Received gifts from: " + p2.giftsReceivedFrom());

        System.out.println();

        System.out.println(p1.getName() + " Received gifts value: " + p1.valueOfGifts());
        System.out.println(p2.getName() + " Received gifts value: " + p2.valueOfGifts());
    }
}

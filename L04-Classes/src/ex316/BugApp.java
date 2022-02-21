package ex316;

public class BugApp {
    public static void main(String[] args) {
        Bug ladybug = new Bug(10);
        ladybug.move();
        ladybug.move();

        // I expect the ladybug to be at position 12
        System.out.println(ladybug.getPosition());

        ladybug.turn();
        ladybug.move();
        ladybug.move();

        //I expect the ladybug to be at position 10 again
        System.out.println(ladybug.getPosition());
    }
}

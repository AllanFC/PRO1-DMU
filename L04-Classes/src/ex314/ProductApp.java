package ex314;

public class ProductApp {
    public static void main(String[] args) {
        Product vildis = new Product("Vild Is", 24.95);
        Product crazyIce = new Product("Crazy Ice", 49.95);

        System.out.println("Original price:");
        System.out.println(vildis.getName() + " " + vildis.getPrice());
        System.out.println(crazyIce.getName() + " " + crazyIce.getPrice());

        vildis.reducePrice(5);
        crazyIce.reducePrice(5);

        System.out.println("Reduced price:");
        System.out.println(vildis.getName() + " " + vildis.getPrice());
        System.out.println(crazyIce.getName() + " " + crazyIce.getPrice());

    }
}

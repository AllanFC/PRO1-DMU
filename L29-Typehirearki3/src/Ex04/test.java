package Ex04;


public class test {
    public static void main(String[] args) {
        Bag bag = new Bag();

        bag.add("Mursten");
        bag.add("Mursten");
        bag.add("Mursten");

        bag.add("Jordbærtærte");
        bag.add("Jordbærtærte");

        bag.add("Toiletpapir");

        System.out.println("---------------------------------------");
        System.out.printf("%-15s %d\n", "Mursten", bag.Count("Mursten"));
        System.out.printf("%-15s %d\n", "Jordbærtærte", bag.Count("Jordbærtærte"));
        System.out.printf("%-15s %d\n", "Toiletpapir", bag.Count("Toiletpapir"));
        System.out.println("---------------------------------------");

    }
}

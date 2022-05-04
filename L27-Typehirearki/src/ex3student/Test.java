package ex3student;


import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Customer c1 = new Customer("Lars", LocalDate.of(1982, 12,12));
        Customer c2 = new Customer("Henrik", LocalDate.of(1994, 4,19));

        Product p1 = new Product(1, "Frozen Pizza",29.95);
        Product p2 = new Product(2, "Ben & Jerry", 65.95);
        Product p3 = new Product(3, "Water bottle", 975);
        Product p4 = new Product(4, "Monster energy", 12.95);
        Product p5 = new Product(5, "Cheese",35);

        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);

        o1.createOrderLine(2, p1);
        o1.createOrderLine(2, p2);
        o2.createOrderLine(2, p3);
        o2.createOrderLine(5,p4);
        o3.createOrderLine(2,p5);
        o3.createOrderLine(1,p1);
        o4.createOrderLine(3,p1);
        o4.createOrderLine(5,p4);

        c1.addOrder(o1);
        c1.addOrder(o2);

        c2.addOrder(o1);
        c2.addOrder(o2);
        c2.addOrder(o3);
        c2.addOrder(o4);

        Discount dp = new PercentDiscount(15);
        Discount df = new FixedDiscount(250, 1000);

        c1.setDiscount(dp);
        c2.setDiscount(df);

        System.out.println("Total pris: " + c1.totalBuy());
        System.out.println("Total pris med discount: " + c1.totalBuyWithDiscount());
        System.out.println();
        System.out.println("Total pris: " + c2.totalBuy());
        System.out.println("Total pris med discount: " + c2.totalBuyWithDiscount());
    }
}

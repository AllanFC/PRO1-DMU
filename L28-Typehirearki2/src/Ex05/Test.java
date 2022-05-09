package Ex05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>(List.of(
                new Electronics("e1", 20, "d1", 10),
                new Food("f1", 15, "d2", LocalDate.of(2022,6,12)),
                new Liquor("l1", 100, "d3", 40)));

        Shoppingcart cart = new Shoppingcart();

        for(Product e : products){
            cart.addProduct(e);
        }

        cart.printReceipt();
    }
}

package Ex05;

import java.util.ArrayList;

public class Shoppingcart {
    private ArrayList<Product> groceries = new ArrayList<>();

    public Shoppingcart(){}

    public void addProduct(Product product){
        groceries.add(product);
    }

    public double totalPriceWithVAT(){
        double sum = 0;
        for(Product e : groceries){
            sum += e.getPriceWithVAT();
        }
        return sum;
    }

    public void printReceipt(){
        System.out.println("  Receipt  ");
        for(Product e : groceries){
            System.out.printf("%-8s%.2f\n",e.getName(), e.getPriceWithVAT());
        }
        System.out.printf("%-8s%.2f","Total",totalPriceWithVAT());
    }
}

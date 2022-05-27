package Ex01;

import java.util.ArrayList;
import java.util.Collections;

public class App{
    public static void main(String[] args) {
        Customer putin = new Customer("Vladimir","Putin", 69);
        Customer lenin = new Customer("Vladimir","Lenin", 152);
        Customer stalin = new Customer("Joseph","Stalin", 90);
        Customer mao = new Customer("Mao","Zedong", 129);
        Customer mussolini= new Customer("Benito","Mussolini",139);
        Customer kimJong = new Customer("Kim-Jong","Un", 80);
        Customer hitler = new Customer("Adolf","Hitler",85);

        ArrayList<Customer> customers1 = new ArrayList<>();
        customers1.add(putin);
        customers1.add(lenin);
        customers1.add(stalin);

        ArrayList<Customer> customers2 = new ArrayList<>();
        customers2.add(mao);
        customers2.add(mussolini);
        customers2.add(kimJong);
        customers2.add(hitler);

        Collections.sort(customers1);
        Collections.sort(customers2);
        System.out.println(mergeAllCustomers(customers1, customers2));
    }

    public static ArrayList<Customer> mergeAllCustomers (ArrayList<Customer> s1, ArrayList<Customer> s2){
        ArrayList<Customer> result = new ArrayList<>();

        // flet sålænge der er noget i begge lister
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).compareTo(s2.get(i2)) < 0) {
                // s1's tal er mindst
                result.add(s1.get(i1));
                i1++;
            }
            else {
                // s2's tal er mindst
                result.add(s2.get(i2));
                i2++;
            }
        }

        // tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }

        return result;
    }
}


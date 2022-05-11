package Ex02;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Customer[] customers = {new Customer("Allan", "Christiansen", 24),
        new Customer("Mads", "Jørgensen", 25),
        new Customer("Lars", "Henriksen", 35),
        new Customer("Mads", "Jørgensen", 26)};

        System.out.println(biggestCustomer(customers));
        System.out.println();
        System.out.println(Arrays.toString(biggerThanCustomer(customers, customers[2])));
    }

    public static Customer biggestCustomer(Customer[] customers){
        Customer biggestCustomer = customers[0];
        for (int i = 1; i < customers.length; i++) {
            biggestCustomer = biggestCustomer.compareTo(customers[i]);
        }
        return biggestCustomer;
    }

    public static Customer[] biggerThanCustomer(Customer[] customers, Customer customer){
        Customer[] biggestCustomers = new Customer[customers.length];
        int counter = 0;
        for(Customer e : customers){
            if(e.compareTo(customer).equals(e)){
                biggestCustomers[counter] = e;
                counter++;
            }
        }
        return biggestCustomers;
    }
}

package ex309;

public class SavingsAccountApp {
    public static void main(String[] args) {
        SavingsAccount a1 = new SavingsAccount(1000, 10);
        a1.addIntrest();
        System.out.println(a1.getBalance());
        System.out.println("1100");
    }
}

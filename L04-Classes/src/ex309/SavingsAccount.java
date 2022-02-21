package ex309;

public class SavingsAccount {
    private double balance;
    private double intrest;

    public SavingsAccount(int balance, int intrest){
        this.balance = balance;
        this.intrest = intrest;
    }

    public double getBalance() {
        return this.balance;
    }

    public void addIntrest() {
        this.balance += (this.intrest / 100) * balance;
    }
}

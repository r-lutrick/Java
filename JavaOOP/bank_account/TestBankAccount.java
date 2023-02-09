
import java.util.Random;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(0, 0);
        Random generator = new Random();

        acc1.depositChecking(generator.nextDouble(0,1000));
        System.out.format("Balance: %.2f", acc1.getCheckingBalance());
        acc1.withdrawChecking(generator.nextDouble(0, acc1.getCheckingBalance()));
        System.out.format("\nBalance: %.2f", acc1.getCheckingBalance());
        
        acc1.depositSavings(generator.nextDouble(0,1000));
        System.out.format("\nBalance: %.2f", acc1.getSavingsBalance());
        acc1.withdrawSaving(generator.nextDouble(0, acc1.getSavingsBalance()));
        System.out.format("\nBalance: %.2f", acc1.getSavingsBalance());
        System.out.format("\nTotal Balance: %.2f", acc1.getTotalBalance());
    }
}

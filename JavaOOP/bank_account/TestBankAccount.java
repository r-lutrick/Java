package JavaOOP.bank_account;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(0, 0);

        acc1.depositChecking(100.00);
        acc1.depositChecking(50.00);
        acc1.depositChecking(40.00);
        acc1.depositChecking(89.00);
        System.out.println(acc1.getAccountNumber());
        System.out.println(acc1.getCheckingBalance());
    }
}

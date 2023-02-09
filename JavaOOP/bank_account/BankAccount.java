package JavaOOP.bank_account;

import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    public static int openAccounts;
    public static double bankBalance;
    // NINJA BONUS
    private String accountNumber;

    // Constructor
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = randomizer();
        openAccounts++;
        bankBalance += checkingBalance + savingsBalance;
    }

    // Getters & Setters
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // DEPOSITS
    // Checking
    public double depositChecking(double deposit) {
        setCheckingBalance(deposit + getCheckingBalance());
        return checkingBalance;
    }

    // Savings
    public double depositSavings(double deposit) {
        setSavingsBalance(deposit + getSavingsBalance());
        return savingsBalance;
    }

    // WITHDRAWL
    // Checking
    public double withdrawChecking(double amount) {
        setCheckingBalance(getCheckingBalance() - amount);
        return checkingBalance;
    }

    // Savings
    public double withdrawSaving(double amount) {
        setSavingsBalance(getSavingsBalance() - amount);
        return checkingBalance;
    }

    // TOTAL
    public double getTotalBalance() {
        return this.savingsBalance + this.checkingBalance;
    }

    // NINJA BONUS
    private String randomizer() {
        Random randomInt = new Random();
        String accountNumber = "";
        for (int i = 0; i < 10; i++) {
            Integer rand = randomInt.nextInt(0, 9);
            String randChar = rand.toString();
            accountNumber = accountNumber + randChar;
        }
        return accountNumber;
    }
}

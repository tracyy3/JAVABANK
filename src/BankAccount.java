public class BankAccount {
    
    private String accUserName;
    private double accBalance;
    private int accNumber;

    public BankAccount () {
        this.accUserName = "";
        this.accBalance = 0;
        this.accNumber = 0;
    }

    public BankAccount (String name, double balance, int accNum) {
        this.accUserName = name;
        this.accBalance = balance;
        this.accNumber = accNum;
    }

    public double deposit (double amount) {
        System.out.println(accUserName + " deposited $" + amount);
        return accBalance += amount;
    }

    public void withdrawal (double amount) {
        if (amount > accBalance) {
            System.out.println(accUserName + " has insufficient funds.");
        } else {
            System.out.println(accUserName + " withdrew $" + amount);
                accBalance -= amount;
        }
    }

    public void transfer (BankAccount recipient, double amount) {
        withdrawal(amount);
        System.out.println(accUserName + "'s balance is now " + accBalance);
            recipient.deposit(amount);
        System.out.println(recipient.accUserName + "'s balance is now " + recipient.accBalance);
    }

    public void getAccountInfo() {
    System.out.println(accUserName + "'s account balance: $" + accBalance);
    }

    public String getName() {
        return accUserName;
    }

    public double getBalance() {
        return accBalance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setName(String name) {
        this.accUserName = name;
    }

    public void setBalance (double balance) {
        this.accBalance = balance;
    }

    public void setID(int length) {
        this.accNumber = length;
    }

    @Override
    public String toString() {
        return "ID: " + getAccNumber() + " " + getName() + "'s balance: " + getBalance();
    }
}
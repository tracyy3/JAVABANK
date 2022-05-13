import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {
private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String a = System.lineSeparator();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        System.out.println("Hello there! - Welcome to ACE Bank.");

        while (true) {
        System.out.println("Are you an existing customer? (Enter -1 to exit)");
        System.out.println("1. Yes" + a + "2. No");
            String response = scanner.nextLine();
                if (response.equalsIgnoreCase("1")) {
        System.out.println("Please confirm ID on the account");
                int query = Integer.valueOf(scanner.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                if (query == accounts.get(i).getAccNumber()) {
                    mainMenu(accounts, accounts.get(i)); 
        } 

        else {
        System.out.println("Invalid ID!");
        continue;
        }
    }
} 

        else if (response.equalsIgnoreCase("2")) {
            accounts.add(new BankAccount());
                int index = accounts.size() - 1;
        System.out.println("Let's create your ACE Bank account!");
        System.out.println("Enter the name of the account.");
            String name = scanner.nextLine();
        System.out.println("Please confirm the beginning balance of the account.");
            int balance = Integer.valueOf(scanner.nextLine());
                accounts.get(index).setName(name);
                accounts.get(index).setBalance(balance);
                accounts.get(index).setID(accounts.size());
                System.out.println(accounts.get(index));
                    mainMenu(accounts, accounts.get(index));
        }    
        
        else if (response.equalsIgnoreCase("-1")) {
            System.out.println("Have a good day! - Goodbye!");
        break;
            }
        }
    }

    public static void mainMenu(ArrayList<BankAccount> accounts, BankAccount currentAccount) {
    String a = System.lineSeparator();

        while (true) {
            System.out.println("Hello " + currentAccount.getName() + "!");
            System.out.println("Welcome to ACE Bank's Main Menu. Please select what you want to do today.");
            System.out.println( "1. Check account balance" + a +
                                "2. Make a withdraw" + a +
                                "3. Make a deposit" + a +
                                "4. Make a money transfer to another account" + a +
                                "5. EXIT");
            String response = scanner.nextLine();

        if (response.equalsIgnoreCase("1")) {
            System.out.println("Your balance is $" + currentAccount.getBalance());
                continue;
        } 

        else if (response.equalsIgnoreCase("2")) {
            System.out.println("Please put the amount you wish to withdraw.");
                currentAccount.withdrawal(Double.valueOf(scanner.nextLine()));
            System.out.println("Your remaining balance is $" + currentAccount.getBalance());
                continue;
        } 

        else if (response.equalsIgnoreCase("3")) {
            System.out.println("Confirm the amount you want to deposit");
                currentAccount.deposit(Double.valueOf(scanner.nextLine()));
            System.out.println("Your new balance is $" + currentAccount.getBalance());
                continue;
            } 

        else if (response.equalsIgnoreCase("4")) {
            System.out.println("Please enter the account number to transfer to");
                int id = Integer.valueOf(scanner.nextLine());
                if (id > accounts.size()) {
            System.out.println("Invalid account, account does not exist!");
                continue;
                } 

        else {
        BankAccount beneficiaries = accounts.get(id - 1);
            System.out.println("Please enter the amount to transfer.");
                double amount = Double.valueOf(scanner.nextLine());
                if (amount > currentAccount.getBalance()) {
            System.out.println("Insufficient funds to transfer.");
                continue;
                } 

        else {
        currentAccount.transfer(beneficiaries, amount);
            }
        }
    } 

        else if (response.equalsIgnoreCase("5")) {
        break;
            }
        }
    }
}
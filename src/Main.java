import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingAccount acct = new BankingAccount();

        System.out.println("Enter name: ");
        String customerName = scanner.nextLine();
        System.out.println("Hello, " + customerName + ". " + "\n");
        System.out.println("____________________________________________");
        System.out.print("         1. check balance" + "\n" +
                "         2. deposit" + "\n" +
                "         3. withdraw" + "\n" +
                "         4. check previous transaction" + "\n" +
                "         5. exit");
        System.out.println("\n" + "--------------------------------------------" + "\n");
        String action = "";
        while (!action.equals("exit") && !action.equals("e") && !action.equals("5")) {
            System.out.println("Enter an option: ");
            action = scanner.nextLine();


            switch (action.toLowerCase()) {
                case "check balance", "balance", "1" -> acct.checkBalance();
                case "deposit", "d", "2" -> {
                    boolean dValidInput = false;
                    while (!dValidInput) {
                        try {
                            System.out.println("Enter an amount to deposit:");
                            double depositAmount = scanner.nextDouble();
                            System.out.println(acct.deposit(depositAmount));
                            dValidInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid amount");
                            dValidInput = false;
                            scanner.next();
                        }
                    }
                }
                case "withdraw", "w", "3" -> {
                    boolean wValidInput = false;
                    while (!wValidInput) {
                        try {
                            System.out.println("Enter an amount to withdraw:");
                            double takeAmount = scanner.nextDouble();
                            System.out.println(acct.withdraw(takeAmount));
                            wValidInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid amount");
                            wValidInput = false;
                            scanner.next();
                        }
                    }
                }
                case "check previous transaction", "previous", "4" -> System.out.println(acct.checkPrev());
                case "exit", "e", "5" -> System.out.println(acct.exitBank());
                default -> System.out.println("Please enter a valid action");
                
            }
        }
    }
}
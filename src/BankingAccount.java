import java.lang.Math;

class BankingAccount
{
    private double balance;
    private double previousTransaction;
    private int previousAction;

    // constructor
    public BankingAccount(int balance, int previousTransaction, int previousAction)
    {
        this.balance = balance;
        this.previousTransaction = previousTransaction;
        this.previousAction = previousAction;
    }

    public BankingAccount()
    {
        this(0, -1, -1);
    }

    public String deposit(double amount)
    {
       balance += amount;
       previousTransaction = amount;
       previousAction = 1;
       return "$" + amount + " deposited successfully. Your balance is now $" + balance + ".";
    }

    public String withdraw(double amount)
    {
        balance -= amount;
        previousTransaction = -amount;
        previousAction = 0;
        return "$" + amount + " withdrew successfully. Your balance is now $" + (balance) + ".";
    }

    public String checkPrev()
    {
        if (previousAction == 1) {
            return "You deposited $" + previousTransaction + ".";
        } else if (previousAction == 0) {
            return "You withdrew $" + Math.abs(previousTransaction) + ".";
        } else {
            return "You haven't done anything yet.";
        }
    }

    public void checkBalance()
    {
        System.out.printf("Your balance is $%.2f", balance);
        System.out.println("." );
//        System.out.println("Your balance is $" + balance + ".");
    }

    public String exitBank()
    {
        return "Thank you for using this bank." + "\n" + "Balance: $" + balance;
    }
}


//869253434317534635632063

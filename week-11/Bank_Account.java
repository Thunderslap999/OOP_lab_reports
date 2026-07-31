
class BankAccountActionInvalidException extends Exception {
    BankAccountActionInvalidException(String message) {
        super(message);
    }
}


class BankAccount {
    private int balance;
    private boolean isOpen;

    synchronized void open() throws BankAccountActionInvalidException {
        if (isOpen) {
            throw new BankAccountActionInvalidException("Account already open");
        }
        isOpen = true;
        balance = 0;
    }

    synchronized void close() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account not open");
        }
        isOpen = false;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amount <= 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        balance += amount;
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amount <= 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if (balance < amount) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
        balance -= amount;
    }
}


public class Bank_Account {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        try {
            System.out.println("--- Testing Bank Account ---");
            account.open();
            System.out.println("Account opened.");
            
            account.deposit(100);
            System.out.println("Deposited 100. Balance: " + account.getBalance());
            
            account.withdraw(50);
            System.out.println("Withdrew 50. Balance: " + account.getBalance());
            
            account.close();
            System.out.println("Account closed.");
            
            // This will purposefully trigger our custom error
            System.out.println("\nAttempting to withdraw from closed account...");
            account.withdraw(10);
            
        } catch (BankAccountActionInvalidException e) {
            System.out.println("Error Caught: " + e.getMessage());
        }
    }
}
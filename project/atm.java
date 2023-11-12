import java.util.*;

public class atm {
    public static void main(String[] args) {
        ATMOperation obj = new ATMOperation();
    }
}

class AccountData {
    int balance;
}

class ATMOperation {
    HashMap<Integer, AccountData> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    ATMOperation() {
        System.out.println("Welcome to our ATM");
        operation();
    }

    public void operation() {
        System.out.println("Enter a valid PIN");

        int pin = sc.nextInt();

        if (map.containsKey(pin)) {
            AccountData obj = map.get(pin);
            menu(obj);
        } else {
            System.out.println("Please create an account first");
            System.out.println("Set a PIN code");
            System.out.println("Set a PIN greater than 1000 and less than 9999");

            int setPin = sc.nextInt();

            AccountData obj = new AccountData();
            if (setPin > 1000 && setPin < 9999) {
                obj.balance = 0;
                map.put(setPin, obj);
                menu(obj);
            } else {
                System.out.println("Invalid PIN. System terminated");
            }
        }
    }

    public void menu(AccountData obj) {
        System.out.println("*****************************************");
        System.out.println("Enter your choice");

        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");
        System.out.println("5. Check another account");
        System.out.println("Enter the option:");

        int x = sc.nextInt();

        switch (x) {
            case 1:
                checkBalance(obj);
                break;
            case 2:
                withdraw(obj);
                break;
            case 3:
                deposit(obj);
                break;
            case 4:
                System.out.println("Thank you for using our ATM");
                break;
            case 5:
                operation();
                break;
            default:
                System.out.println("Enter a valid option");
                menu(obj);
                break;
        }
    }

    public void checkBalance(AccountData obj) {
        System.out.println("Your current balance: " + obj.balance);
        System.out.println("*****************************************");
        menu(obj);
    }

    public void deposit(AccountData obj) {
        System.out.println("Enter the amount: ");
        float depositAmount = sc.nextFloat();
        if (depositAmount < 0) {
            System.out.println("Invalid amount");
            deposit(obj);
        } else {
            obj.balance += depositAmount;
            System.out.println("Amount deposited successfully");
            System.out.println("*****************************************");
            menu(obj);
        }
    }

    public void withdraw(AccountData obj) {
        System.out.println("Enter the amount: ");
        float withdrawAmount = sc.nextFloat();
        if (withdrawAmount > obj.balance) {
            System.out.println("Insufficient balance");
            menu(obj);
        } else {
            obj.balance -= withdrawAmount;
            System.out.println("Amount withdrawn successfully");
            System.out.println("*****************************************");
            menu(obj);
        }
    }
}

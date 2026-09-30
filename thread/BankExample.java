package thread;

class BankAccount {

    private int balance = 1000;

    public synchronized void withdraw(int amount) {

        System.out.println(
            Thread.currentThread().getName() + " is trying to withdraw ₹" + amount );

        if (balance >= amount) {

            System.out.println( Thread.currentThread().getName() +" is processing..." );
                

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }

            balance = balance - amount;

            System.out.println( Thread.currentThread().getName() +  " withdrew ₹" + amount);

            System.out.println(
                "Remaining balance: ₹" + balance
            );

        } else {

            System.out.println(
                Thread.currentThread().getName() +
                " cannot withdraw ₹" + amount
            );

            System.out.println(
                "Insufficient balance"
            );
        }
    }
}

class WithdrawThread extends Thread {

    private BankAccount account;
    private int amount;

    WithdrawThread(BankAccount account, int amount, String name) {
        this.account = account;
        this.amount = amount;

        setName(name);
    }

    @Override
    public void run() {

        account.withdraw(amount);
    }
}

public class BankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        WithdrawThread t1 =  new WithdrawThread(account, 700, "Thread-1");

        WithdrawThread t2 =  new WithdrawThread(account, 500, "Thread-2");

        t1.start();
        t2.start();
    }
}

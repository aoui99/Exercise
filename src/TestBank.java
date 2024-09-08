import java.util.Random;

public class TestBank {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(0);

        DepositThread dt = new DepositThread(b);
        WithdrawThread wt = new WithdrawThread(b);

        dt.start();
        wt.start();

        try {
            dt.join();
            wt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("deposit money: " + b.getTotalDeposits());
        System.out.println("withdraw money: " + b.getTotalWithdrawals());
        System.out.println("Final balance: " + b.getAccount());
    }
}

class DepositThread extends Thread {
    private BankAccount bank;
    private Random r;

    public DepositThread(BankAccount b) {
        bank = b;
        this.r = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            float f1 = r.nextInt(100)+1;
            bank.deposit(f1);
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount bank;
    private Random r;

    public WithdrawThread(BankAccount b) {
        bank = b;
        this.r = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            float f2 = r.nextInt(100)+1;
            bank.withdraw(f2);
        }
    }
}


class BankAccount {

    private float account;
    private float totalDeposits;
    private float totalWithdrawals;

    public BankAccount(float money) {
        this.account = money;
        this.totalDeposits = 0;
        this.totalWithdrawals = 0;
    }


    public synchronized float getAccount() {
        return account;
    }
    public synchronized float getTotalDeposits() {
        return totalDeposits;
    }

    public synchronized float getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public synchronized void deposit(float money) {
        account += money;
        totalDeposits += money;
        System.out.println("存款："+money+"余额："+account);
        notify();
    }

    public synchronized void withdraw(float money) {
        while (account < money) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        account -= money;
        totalWithdrawals += money;
        System.out.println("取款："+money+"余额："+account);
    }

    public synchronized void showTransactionDetails(String operation, float amount) {
        System.out.println("Operation: " + operation + ", Amount: " + amount + ", New balance: " + account);
    }
}

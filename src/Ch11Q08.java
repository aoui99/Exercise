import java.util.ArrayList;
import java.util.Date;

public class Ch11Q08 {
    public static void main(String[] args) {
        Account account = new Account("George",1122,1000);
        System.out.println(account);
        account.setAnnualInterestRate(0.015);
        //存款30
        double amount = 30;
        double balance = account.getBalance() + amount;
        account.setBalance(balance);
        // 操作，存取款
        Transaction transaction = new Transaction('D', amount, balance, "工资");
        account.transactions.add(transaction);
        //存款40
        amount = 40;
        balance = account.getBalance() + amount;
        account.setBalance(balance);
        Transaction transaction1 = new Transaction('D', amount, balance, "工资");
        account.transactions.add(transaction1);
        //存款50
        amount = 50;
        balance = account.getBalance() + amount;
        account.setBalance(balance);
        Transaction transaction2 = new Transaction('D', amount, balance, "工资");
        account.transactions.add(transaction2);
        //取款5
        amount = 5;
        balance = account.getBalance() - amount;
        account.setBalance(balance);
        Transaction transaction3 = new Transaction('W', amount, balance, "KFC");
        account.transactions.add(transaction3);
        //取款4
        amount = 4;
        balance = account.getBalance() - amount;
        account.setBalance(balance);
        Transaction transaction4 = new Transaction('W', amount, balance, "牙刷");
        account.transactions.add(transaction4);
        //取款2
        amount = 2;
        balance = account.getBalance() - amount;
        account.setBalance(balance);
        Transaction transaction5 = new Transaction('W', amount, balance, "医院");
        account.transactions.add(transaction5);

        account.toString();
        account.printTransactions();
        // new
        // add
        // loop transactions
    }
}

class Transaction {
    //
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    public Transaction(char type, double amount, double balance, String description){
        Date dNow = new Date();
        this.date = dNow;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //Override



}

class Account {
    // balance id date interest
    // + name
    ArrayList<Transaction> transactions;
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String name;

    public Account() {
        this.name = "";
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        Date dNow = new Date();
        this.dateCreated = dNow;
        this.transactions = new ArrayList<>();
    }

    public Account(int ID, double balance) {
        this.name = "";
        this.id = ID;
        this.balance = balance;
        this.annualInterestRate = 0;
        Date dNow = new Date();
        this.dateCreated = dNow;
        this.transactions = new ArrayList<>();
    }

    public Account(String name, int ID, double balance) {
        this.name = name;
        this.id = ID;
        this.balance = balance;
        this.annualInterestRate = 0;
        Date dNow = new Date();
        this.dateCreated = dNow;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = annualInterestRate / 12;
        return balance * monthlyInterestRate/100;
    }

    void withDraw(int amount) {
        this.balance = balance - amount;
    }
    void deposit(int amount){
        this.balance = balance + amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }

    public void printTransactions() {
        System.out.println("姓名："+name);
        System.out.println("利率："+annualInterestRate);
        System.out.println("收支额："+balance);
        System.out.println("------------------");
        for (Transaction transaction : transactions) {
            System.out.println("交易类型："+transaction.getType());
            System.out.println("交易日期："+transaction.getDate());
            System.out.println("交易量："+transaction.getAmount());
            System.out.println("交易余额："+transaction.getBalance());
            System.out.println("交易描述："+transaction.getDescription());
            System.out.println("------------------");
        }

    }
}

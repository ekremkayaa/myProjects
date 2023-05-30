import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private Client client;
    private ArrayList<Transaction> transactions;

    public Account(int id, double balance, double annualInterestRate, Client client){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;

        this.transactions = new ArrayList<>();
        this.dateCreated = new Date();
    }

    public boolean withDraw(double amount){
        if(this.balance < amount)
            return false;

        this.balance -= amount;
        this.transactions.add(new Transaction('W',amount,this.balance,"Withdrawn "+amount));
        return true;
    }

    public void deposit(double amount){
        this.balance += amount;
        this.transactions.add(new Transaction('D',amount,this.balance,"Deposit "+amount));
    }
    public int countTransactions(char type){
        int count = 0;
        for(Transaction transaction : transactions)
            if(transaction.getType() == type)
                count++;

        return count;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString(){
        return this.id + " " + this.balance + " " + this.annualInterestRate + " " + this.dateCreated ;
    }

}


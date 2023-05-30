import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Client client = new Client(100,"Ekrem","5324562312");

        accounts.add(new Account(1,2000,3.4,client));
        accounts.add(new Account(2,3000,3.5,client));

        accounts.get(0).withDraw(2000);
        accounts.get(0).withDraw(1000);
        accounts.get(0).deposit(2000);
        accounts.get(0).withDraw(1000);

        accounts.get(1).deposit(100);
        accounts.get(1).deposit(300);

        for(Account account : accounts){
            System.out.println("Account " + account.getId() + ":");
            System.out.println("W: "+account.countTransactions('W'));
            System.out.println("D: "+account.countTransactions('D'));
        }

        System.out.println(accounts.get(0));
    }
}



package application;

import entities.BusinessAccount;
import entities.Account;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Alexe", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCasting

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        // acc2 funciona pq uma BusinnesAccount também é uma Account

        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DownCasting

        // BusinessAccount acc4 = acc2; assim não funciona
        BusinessAccount acc4 = (BusinessAccount)acc2; // faço cum casting
        acc4.loan(100.0);

        //BusinessAccount acc5 = (BusinessAccount)acc3; // vai dar erro pq a acc3 é uma SavingsAccount e não é BusinessAccount

        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("loan!");
        }

        if (acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");

        }

        System.out.println();
        System.out.println();
        System.out.println("polimorfismo");
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);
        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println(x.getBalance());
        System.out.println(y.getBalance());
    }
}
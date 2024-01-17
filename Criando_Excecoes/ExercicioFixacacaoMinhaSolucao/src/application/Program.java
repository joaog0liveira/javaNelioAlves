package application;

import model.entities.Account;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.println("number: ");
        int number = ler.nextInt();
        ler.nextLine();
        System.out.println("Holder: ");
        String holder = ler.nextLine();
        System.out.println("Initial balance: ");
        double balance = ler.nextDouble();
        System.out.println("Withdraw limit: ");
        double limit = ler.nextDouble();

        Account account = new Account(number, holder, balance, limit);

        System.out.println();
        System.out.println("Enter the amount for withdraw: ");
        double withdraw = ler.nextDouble();

        try{

            account.withdraw(withdraw);
            System.out.println("New balance: " + account.getBalance());

        } catch (IllegalArgumentException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

    }
}

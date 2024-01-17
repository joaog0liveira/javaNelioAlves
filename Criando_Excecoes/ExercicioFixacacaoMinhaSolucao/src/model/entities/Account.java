package model.entities;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private double withDrawLimit;

    public Account(Integer number, String holder, Double balance, double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (withDrawLimit < amount) {
            throw new IllegalArgumentException("the amount exceeds withdraw limit!");
        }
        else if (balance < amount) {
            throw new IllegalArgumentException("not enough balance");
        }
        balance -= amount;
    }

}

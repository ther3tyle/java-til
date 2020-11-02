package io.dsub.day21;

// POJO - Plain Old Java Object

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int value) {
        balance -= value;
    }

    public void deposit(int value) {
        balance += value;
    }

    public boolean isMinus() {
        return balance < 0;
    }

    public void throwException() {
        throw new ArithmeticException();
    }
}

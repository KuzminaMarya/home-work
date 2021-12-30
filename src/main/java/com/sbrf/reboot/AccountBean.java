package com.sbrf.reboot;

public class AccountBean {
    private int number;
    private int balance;
    private String currency;

    public AccountBean(int number, int balance, String currency){
        this.number=number;
        this.balance=balance;
        this.currency=currency;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public String getCurrency() {
        return currency;
    }
}

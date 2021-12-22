package com.sbrf.reboot;

import java.time.LocalDate;

public class AccountC {
    private int balance;
    private String currency;
    private LocalDate dateCreated;

    public AccountC(int balance, String currency, LocalDate dateCreated){
        this.balance=balance;
        this.currency=currency;
        this.dateCreated=dateCreated;
    }

    public int getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}

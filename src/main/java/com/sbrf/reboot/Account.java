package com.sbrf.reboot;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;



@Builder
public class Account {
    private long id;
    private LocalDate createDate;
    private BigDecimal balance;

    public Account(long id, LocalDate createDate, BigDecimal balance) {
        this.id = id;
        this.createDate = createDate;
        this.balance=balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object obj){
        Account account=(Account)obj;
        if(this.getId()==account.getId()&&this.getCreateDate().isEqual(account.getCreateDate())&&this.getBalance().compareTo(account.getBalance())==0)
            return true;
        else
            return false;
    }
}

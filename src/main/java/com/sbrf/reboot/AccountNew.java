package com.sbrf.reboot;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public class AccountNew {
    private String id;
    private long clientId;
    private LocalDate createDate;
    private BigDecimal balance;

    public AccountNew(String id, long clientId, LocalDate createDate, BigDecimal balance) {
        this.id = id;
        this.clientId=clientId;
        this.createDate = createDate;
        this.balance=balance;
    }

    public AccountNew(String id) {
        this.id = id;
        this.clientId=0;
        this.createDate = LocalDate.now();
        this.balance=BigDecimal.ZERO;
    }

    public String getId() {
        return id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

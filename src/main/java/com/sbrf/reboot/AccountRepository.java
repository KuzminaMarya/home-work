package com.sbrf.reboot;

import java.util.Set;

public class AccountRepository {
    private Set<Account> accounts;

    public AccountRepository(Set<Account> accounts){
        this.accounts=accounts;
    }

    public Set<Account> getAllAccountsByClientId(long clientId){
        return accounts;
    }
}

package com.sbrf.reboot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AccountRepository implements AccountServiceInterface {
    private Set<Account> accounts;
    private Long clientId;

    public AccountRepository(Long clientId, Set<Account> accounts) {
        this.accounts = accounts;
        this.clientId = clientId;
    }

    public Set<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        return this.accounts;
    }
}

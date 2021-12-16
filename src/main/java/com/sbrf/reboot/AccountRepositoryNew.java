package com.sbrf.reboot;

import java.util.Set;

public class AccountRepositoryNew {
    private Set<AccountNew> accountNews;

    public AccountRepositoryNew(Set<AccountNew> accountNews){
        this.accountNews = accountNews;
    }

    public Set<AccountNew> getAllAccountsByClientId(long clientId){
        return accountNews;
    }
}

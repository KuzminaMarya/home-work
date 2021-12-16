package com.sbrf.reboot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountServiceNew {
    private AccountRepositoryNew accountRepositoryNew;

    public AccountServiceNew(AccountRepositoryNew accountRepositoryNew){
        this.accountRepositoryNew = accountRepositoryNew;
    }

    public boolean isAccountExist(long clientId, AccountNew accountNew){
        Stream<AccountNew> stream= accountRepositoryNew.getAllAccountsByClientId(clientId).stream();
        return stream.anyMatch(accountNew1 -> accountNew.getId()== accountNew1.getId());
    }

    public BigDecimal getMaxAccountBalance(long clientId) {
        Stream<AccountNew> stream = accountRepositoryNew.getAllAccountsByClientId(clientId).stream();
        return stream.max(Comparator.comparing(accountNew -> accountNew.getBalance())).get().getBalance();
    }

    public Set<AccountNew> getAllAccountsByDateMoreThen(long clientId, LocalDate localDate){
        Stream<AccountNew> stream = accountRepositoryNew.getAllAccountsByClientId(clientId).stream();
        return stream.filter(accountNew -> accountNew.getCreateDate().isAfter(localDate)|| accountNew.getCreateDate().isEqual(localDate)).collect(Collectors.toSet());
    }

    public BigDecimal getMinAccountBalance(long clientId) {
        Stream<AccountNew> stream = accountRepositoryNew.getAllAccountsByClientId(clientId).stream();
        return stream.min(Comparator.comparing(accountNew -> accountNew.getBalance())).get().getBalance();
    }
}

package com.sbrf.reboot;

import java.math.BigDecimal;
import java.security.AccessController;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account){
        Stream<Account> stream=accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.anyMatch(account1->account.getId()== account1.getId());
    }

    public BigDecimal getMaxAccountBalance(long clientId) {
        Stream<Account> stream = accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.max(Comparator.comparing(account -> account.getBalance())).get().getBalance();
    }

    public Set<Account> getAllAccountsByDateMoreThen(long clientId, LocalDate localDate){
        Stream<Account> stream = accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.filter(account -> account.getCreateDate().isAfter(localDate)||account.getCreateDate().isEqual(localDate)).collect(Collectors.toSet());
    }

    public BigDecimal getMinAccountBalance(long clientId) {
        Stream<Account> stream = accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.min(Comparator.comparing(account -> account.getBalance())).get().getBalance();
    }
}

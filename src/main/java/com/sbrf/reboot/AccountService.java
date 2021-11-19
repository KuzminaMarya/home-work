package com.sbrf.reboot;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) throws IOException {
        if (this.accountRepository.getAllAccountsByClientId(1L).contains(account)) {
            return true;
        } else {
            return false;
        }
    }
}

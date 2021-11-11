package com.sbrf.reboot;

public class AccountService {
    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) {
        if(this.accountRepository.getAllAccountsByClientId(1L).contains(account)){
            return true;
        }
        else {
            return false;
        }
    }
}

package com.sbrf.reboot;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountRepositoryImpl extends AccountRepository implements AccountServiceInterface {
    private String file;

    public AccountRepositoryImpl(String file) {
        super(1L, new HashSet<>());
        this.file = file;
    }

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        Set<Account> accounts = new HashSet<>();
        String number;
        InputStream inputStream = new FileInputStream(file);
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        while ((number = bf.readLine()) != null) {
            accounts.add(new Account(number));
        }
        bf.close();
        inputStream.close();
        AccountRepository accountRepository = new AccountRepository(clientId, accounts);
        Iterator<Account> it = accountRepository.getAccounts().iterator();
        System.out.println("Для клиента c id " + accountRepository.getClientId() + " счета :");
        while (it.hasNext()) {
            System.out.println(it.next().getNumber());
        }
        return accounts;
    }
}

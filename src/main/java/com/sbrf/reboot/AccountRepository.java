package com.sbrf.reboot;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
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

    public void updateAccountByClientId(long clientId, String number, String newNumber, String file) throws IOException {
        Set<Account> accounts=getAllAccountsByClientId(clientId);
        OutputStream outStream = new FileOutputStream(file);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(outStream));
        bf.write("");
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            String num=it.next().getNumber();
            if (!num.equals(number)){
                bf.write(num);
                bf.newLine();
            }
        }
        bf.write(newNumber);
        bf.close();
        outStream.close();
    }
}

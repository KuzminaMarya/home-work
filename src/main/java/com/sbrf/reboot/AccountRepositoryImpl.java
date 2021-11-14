package com.sbrf.reboot;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountRepositoryImpl implements AccountServiceInterface {

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws FileNotFoundException {
        Set<Account> accounts = new HashSet<>();
        try {
            String number;
            InputStream inputStream = new FileInputStream("C:/Users/Lenovo/Documents/Git/home-work/src/main/resources/Accounts.txt");
            BufferedReader bf= new BufferedReader(new InputStreamReader(inputStream));
            while ((number=bf.readLine())!=null){
                accounts.add(new Account(number));
            }
            bf.close();
            inputStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл с перечнем счетов не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        AccountRepository accountRepository = new AccountRepository(clientId,accounts);
        Iterator<Account> it =accountRepository.getAccounts().iterator();
        System.out.println("Для клиента c id " + accountRepository.getClientId() + " счета :");
        while (it.hasNext()) {
            System.out.println(it.next().getNumber());
        }
        return accounts;
    }
}

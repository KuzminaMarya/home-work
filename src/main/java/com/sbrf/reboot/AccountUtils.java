package com.sbrf.reboot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static void sortedById(List<Account> accounts) {
        Comparator<Account> comparator=Comparator.comparing(account -> account.getId());
        Collections.sort(accounts,comparator);
    }

    public static void sortedByIdDate(List<Account> accounts) {
        boolean isSorted=false;
        Account buf;

        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < accounts.size()-1; i++) {
                if(accounts.get(i).getId()>accounts.get(i+1).getId()){
                    isSorted=false;

                    buf=accounts.get(i);
                    accounts.remove(i);
                    accounts.add(i+1,buf);
                }
            }
        }

        isSorted=false;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < accounts.size()-1; i++) {
                if(accounts.get(i).getId()==accounts.get(i+1).getId()){
                    if(accounts.get(i).getCreateDate().isAfter(accounts.get(i+1).getCreateDate())) {
                        isSorted = false;

                        buf = accounts.get(i);
                        accounts.remove(i);
                        accounts.add(i+1,buf);
                    }
                }
            }
        }
    }

    public static void sortedByIdDateBalance(List<Account> accounts) {
        boolean isSorted=false;
        Account buf;

        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < accounts.size()-1; i++) {
                if(accounts.get(i).getId()>accounts.get(i+1).getId()){
                    isSorted=false;

                    buf=accounts.get(i);
                    accounts.remove(i);
                    accounts.add(i+1,buf);
                }
            }
        }

        isSorted=false;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < accounts.size()-1; i++) {
                if(accounts.get(i).getId()==accounts.get(i+1).getId()){
                    if(accounts.get(i).getCreateDate().isAfter(accounts.get(i+1).getCreateDate())) {
                        isSorted = false;

                        buf = accounts.get(i);
                        accounts.remove(i);
                        accounts.add(i+1,buf);
                    }
                }
            }
        }
        isSorted=false;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < accounts.size()-1; i++) {
                if(accounts.get(i).getId()==accounts.get(i+1).getId()){
                    if(accounts.get(i).getCreateDate().isEqual(accounts.get(i+1).getCreateDate())) {
                        if(accounts.get(i).getBalance().compareTo(accounts.get(i+1).getBalance())==-1) {
                            isSorted = false;

                            buf = accounts.get(i);
                            accounts.remove(i);
                            accounts.add(i + 1, buf);
                        }
                    }
                }
            }
        }
    }
}

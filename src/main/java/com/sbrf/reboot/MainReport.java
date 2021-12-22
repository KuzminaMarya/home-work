package com.sbrf.reboot;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

public class MainReport {
    static public int getTotalsWithCompletableFuture(Stream<Customer> streamCustomer) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()
                -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            int sumBalance = 0;
            Set<Customer> customers = streamCustomer.filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30).collect(Collectors.toSet());
            Iterator<Customer> iterator = customers.iterator();
            while (iterator.hasNext()) {
                Stream<AccountC> streamAccount = iterator.next().getAccount().stream();
                sumBalance += streamAccount.filter(accountC -> accountC.getDateCreated().isAfter(LocalDate.of(2021, 7, 1)) && accountC.getDateCreated().isBefore(LocalDate.of(2021, 8, 1)) && accountC.getCurrency().equals("RUB")).mapToInt(value -> value.getBalance()).sum();
            }
            System.out.println("Result of the asynchronous computation");
            return sumBalance;
        });

        return future.get();
    }

    static public int getTotalsWithReact(Stream<Customer> streamCustomer) throws InterruptedException {
        int sumBalance = 0;
        Set<Customer> customers = streamCustomer.filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30).collect(Collectors.toSet());
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Stream<AccountC> streamAccount = iterator.next().getAccount().stream();
            sumBalance += streamAccount.filter(accountC -> accountC.getDateCreated().isAfter(LocalDate.of(2021, 7, 1)) && accountC.getDateCreated().isBefore(LocalDate.of(2021, 8, 1)) && accountC.getCurrency().equals("RUB")).mapToInt(value -> value.getBalance()).sum();
        }
        return sumBalance;
    }
}
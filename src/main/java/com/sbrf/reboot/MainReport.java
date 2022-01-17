package com.sbrf.reboot;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

public class MainReport {

    public static CompletableFuture<Set<Customer>> getCustomers(Stream<Customer> streamCustomer) {
        System.out.println("Выполнено в одном потоке");
        return CompletableFuture.supplyAsync(()
                -> {
            Set<Customer> customers = streamCustomer.filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30).collect(Collectors.toSet());
            return customers;
        });
    }

    public static CompletableFuture<Integer> getTotals(Set<Customer> customers) {
        System.out.println("Выполнено в другом потоке");
        return CompletableFuture.supplyAsync(() -> {
            int sumBalance = 0;
            for (Customer customer : customers) {
                Stream<AccountC> streamAccount = customer.getAccount().stream();
                sumBalance += streamAccount.filter(accountC -> accountC.getDateCreated().isAfter(LocalDate.of(2021, 7, 1)) && accountC.getDateCreated().isBefore(LocalDate.of(2021, 8, 1)) && accountC.getCurrency().equals("RUB")).mapToInt(value -> value.getBalance()).sum();
            }
            return sumBalance;
        });
    }

    static public int getTotalsWithCompletableFuture(Stream<Customer> streamCustomer) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> result = getCustomers(streamCustomer).thenCompose(customers->getTotals(customers));
        return result.get();
    }

   static public int getTotalsWithReact(Stream<Customer> streamCustomer) throws InterruptedException {
        int sumBalance = 0;
        Set<Customer> customers = streamCustomer.filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30).collect(Collectors.toSet());
        for(Customer customer:customers){
            Stream<AccountC> streamAccount = customer.getAccount().stream();
            sumBalance += streamAccount.filter(accountC -> accountC.getDateCreated().isAfter(LocalDate.of(2021, 7, 1)) && accountC.getDateCreated().isBefore(LocalDate.of(2021, 8, 1)) && accountC.getCurrency().equals("RUB")).mapToInt(value -> value.getBalance()).sum();
        }
        return sumBalance;
    }
}

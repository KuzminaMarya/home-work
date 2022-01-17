package com.sbrf.reboot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

public class MainReportTest {
    @Test
    void getTotalsWithCompletableFutureTest() throws ExecutionException, InterruptedException {
        Set<AccountC> accountLisa=new HashSet(){{
            add(new AccountC(1000,"RUB", LocalDate.of(2021, 7, 2)));
            add(new AccountC(1000,"USD", LocalDate.of(2021, 7, 1)));
        }};

        Set<AccountC> accountMary=new HashSet(){{
            add(new AccountC(1000,"RUB", LocalDate.of(2021, 7, 5)));
            add(new AccountC(1000,"USD", LocalDate.of(2021, 8, 1)));
        }};

        Set<AccountC> accountNik=new HashSet(){{
            add(new AccountC(2000,"USD", LocalDate.of(2021, 7, 5)));
            add(new AccountC(2000,"RUB", LocalDate.of(2021, 7, 6)));
        }};

        Set<Customer> accountCustomer = new HashSet() {{
            add(new Customer(18,"Lisa", accountLisa));
            add(new Customer(31,"Mary", accountMary));
            add(new Customer(20,"Nik", accountNik));
        }};
        int sumbalance = MainReport.getTotalsWithCompletableFuture(accountCustomer.stream());
        assertEquals(3000, sumbalance);
    }

    @Test
    void getTotalsWithReactTest() throws InterruptedException {
        Set<AccountC> accountLisa=new HashSet(){{
            add(new AccountC(1000,"RUB", LocalDate.of(2021, 7, 2)));
            add(new AccountC(1000,"USD", LocalDate.of(2021, 7, 1)));
        }};

        Set<AccountC> accountMary=new HashSet(){{
            add(new AccountC(1000,"RUB", LocalDate.of(2021, 7, 5)));
            add(new AccountC(1000,"USD", LocalDate.of(2021, 8, 1)));
        }};

        Set<AccountC> accountNik=new HashSet(){{
            add(new AccountC(2000,"USD", LocalDate.of(2021, 7, 5)));
            add(new AccountC(2000,"RUB", LocalDate.of(2021, 7, 6)));
        }};

        Set<Customer> accountCustomer = new HashSet() {{
            add(new Customer(18,"Lisa", accountLisa));
            add(new Customer(31,"Mary", accountMary));
            add(new Customer(20,"Nik", accountNik));
        }};
        final int[] sumbalance = {0};
        Scheduler s=Schedulers.parallel();
        final Flux<Integer> sum=Flux.just(MainReport.getTotalsWithReact(accountCustomer.stream())).map(i-> sumbalance[0] +=i).publishOn(s);
        Thread thread=new Thread(() -> sum.subscribe(v->System.out.println("Результат из побочного потока: "+v)));
        thread.start();
        thread.join();
        assertEquals(3000, sumbalance[0]);
    }
}

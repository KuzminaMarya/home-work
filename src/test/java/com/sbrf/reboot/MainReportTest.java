package com.sbrf.reboot;

import org.junit.jupiter.api.Test;
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
        final int[] sumbalance=new int[1];
        Thread thread=new Thread(() -> {
            try {
                sumbalance[0]=MainReport.getTotalsWithReact(accountCustomer.stream());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Результат из побочного потока");
    });
        thread.start();
        thread.join();
        assertEquals(3000, sumbalance[0]);
    }
}

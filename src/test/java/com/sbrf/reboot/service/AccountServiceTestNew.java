package com.sbrf.reboot.service;

import com.sbrf.reboot.AccountNew;
import com.sbrf.reboot.AccountRepositoryNew;
import com.sbrf.reboot.AccountServiceNew;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTestNew {

    @Mock
    AccountRepositoryNew accountRepositoryNew;

    AccountServiceNew accountServiceNew;

    @BeforeEach
    void setUp() {
        accountRepositoryNew = Mockito.mock(AccountRepositoryNew.class);
        accountServiceNew = new AccountServiceNew(accountRepositoryNew);
    }

    @SneakyThrows
    @Test
    void bookExist() {
        AccountNew accountNew = new AccountNew("ACC1234NUM");
        Set<AccountNew> accountNews = new HashSet();
        accountNews.add(accountNew);

        when(accountRepositoryNew.getAllAccountsByClientId(1L)).thenReturn(accountNews);

        assertTrue(accountServiceNew.isAccountExist(1L, accountNew));
    }

    @SneakyThrows
    @Test
    void bookNotExist() {
        Set<AccountNew> accountNews = new HashSet();
        accountNews.add(new AccountNew("ACC1234NUM"));

        when(accountRepositoryNew.getAllAccountsByClientId(1L)).thenReturn(accountNews);

        assertFalse(accountServiceNew.isAccountExist(1L, new AccountNew("ACC456NUM")));
    }

    @SneakyThrows
    @Test
    void getMaxAccountBalance() {
        AccountNew accountNewWithMaxBalance = AccountNew.builder().clientId(1L).id("4L").balance(new BigDecimal(150000)).build();
        Set<AccountNew> accountNews = new HashSet() {{
            add(AccountNew.builder().clientId(1L).id("1L").balance(BigDecimal.TEN).build());
            add(AccountNew.builder().clientId(1L).id("2L").balance(new BigDecimal(200)).build());
            add(AccountNew.builder().clientId(1L).id("3L").balance(new BigDecimal("1.65")).build());
            add(accountNewWithMaxBalance);
        }};

        when(accountRepositoryNew.getAllAccountsByClientId(1L)).thenReturn(accountNews);

        assertEquals(accountNewWithMaxBalance.getBalance(), accountServiceNew.getMaxAccountBalance(1L));
    }

    @SneakyThrows
    @Test
    void getAllAccountsByDateMoreThen() {
        AccountNew accountNew1 = AccountNew.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(2))
                .build();
        AccountNew accountNew2 = AccountNew.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(3))
                .build();
        AccountNew accountNew3 = AccountNew.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(1))
                .build();
        AccountNew accountNew4 = AccountNew.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(7))
                .build();

        Set<AccountNew> accountNews = new HashSet() {{
            add(accountNew1);
            add(accountNew2);
            add(accountNew3);
            add(accountNew4);
        }};

        when(accountRepositoryNew.getAllAccountsByClientId(1L)).thenReturn(accountNews);

        Set allAccountsByDateMoreThen = accountServiceNew.getAllAccountsByDateMoreThen(1L, LocalDate.now().minusDays(2));

        assertEquals(2, allAccountsByDateMoreThen.size());
        assertTrue(allAccountsByDateMoreThen.contains(accountNew3));
    }

    @SneakyThrows
    @Test
    void getMinAccountBalance() {
        AccountNew accountNewWithMaxBalance = AccountNew.builder().clientId(1L).id("4L").balance(new BigDecimal("0.25")).build();
        Set<AccountNew> accountNews = new HashSet() {{
            add(AccountNew.builder().clientId(1L).id("1L").balance(BigDecimal.TEN).build());
            add(AccountNew.builder().clientId(1L).id("2L").balance(new BigDecimal(200)).build());
            add(AccountNew.builder().clientId(1L).id("3L").balance(new BigDecimal("1.65")).build());
            add(accountNewWithMaxBalance);
        }};

        when(accountRepositoryNew.getAllAccountsByClientId(1L)).thenReturn(accountNews);

        assertEquals(accountNewWithMaxBalance.getBalance(), accountServiceNew.getMinAccountBalance(1L));
    }
}

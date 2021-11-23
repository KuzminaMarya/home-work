package com.sbrf.reboot.utils;

import com.sbrf.reboot.Account;
import com.sbrf.reboot.AccountUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class AccountUtilsTest {

    @Test
    void sortedById() {
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(Account.builder().id(3L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
            add(Account.builder().id(1L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
            add(Account.builder().id(3L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
            add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        }};

        AccountUtils.sortedById(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(3L, accounts.get(2).getId());
        Assertions.assertEquals(3L, accounts.get(3).getId());
    }

    @Test
    void sortedByIdDate() {
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(Account.builder().id(1L).createDate(LocalDate.now().minusDays(4)).balance(BigDecimal.TEN).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.TEN).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.TEN).build());
            add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        }};

        AccountUtils.sortedByIdDate(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(LocalDate.now().minusDays(3), accounts.get(2).getCreateDate());
        Assertions.assertEquals(LocalDate.now().minusDays(1), accounts.get(3).getCreateDate());
    }

    @Test
    void sortedByIdDateBalance() {
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(Account.builder().id(1L).createDate(LocalDate.now().minusDays(4)).balance(BigDecimal.valueOf(27000)).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.valueOf(30000)).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.valueOf(26000)).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.valueOf(28000)).build());
            add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.valueOf(25000)).build());
        }};

        AccountUtils.sortedByIdDateBalance(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(LocalDate.now().minusDays(3), accounts.get(2).getCreateDate());
        Assertions.assertEquals(LocalDate.now().minusDays(1), accounts.get(3).getCreateDate());
        Assertions.assertEquals(LocalDate.now().minusDays(1), accounts.get(4).getCreateDate());
        Assertions.assertEquals(BigDecimal.valueOf(28000), accounts.get(3).getBalance());
        Assertions.assertEquals(BigDecimal.valueOf(26000), accounts.get(4).getBalance());
    }
}

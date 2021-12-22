package com.sbrf.reboot;

import java.util.Set;
import lombok.Builder;

@Builder
public class Customer {
    private int age;
    private String name;
    private Set<AccountC> account;

    public Customer(int age, String name, Set<AccountC> account){
        this.age=age;
        this.account=account;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Set<AccountC> getAccount() {
        return account;
    }
}

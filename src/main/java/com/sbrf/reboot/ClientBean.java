package com.sbrf.reboot;


public class ClientBean {
    private String name;
    private int age;

    public ClientBean(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
package com.sbrf.reboot;

import java.util.ArrayList;

public class Cassette<T> {

    private  ArrayList<T> banknotes;

    public Cassette(ArrayList<T> banknotes) {
        this.banknotes=banknotes;
    }

    public int getCountBanknotes(){
        return banknotes.size();
    }
}

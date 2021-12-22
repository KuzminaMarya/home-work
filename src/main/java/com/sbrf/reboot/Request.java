package com.sbrf.reboot;

import java.io.Serializable;

public class Request implements Serializable {
    private String atmNumber;

    public Request(String atmNumber){
        this.atmNumber=atmNumber;
    }

    public String getAtmNumber() {
        return atmNumber;
    }
}
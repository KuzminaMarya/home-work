package com.sbrf.reboot;

import java.io.Serializable;

public class Response implements Serializable {
    private String statusCode;

    public Response(String statusCode){
        this.statusCode=statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}

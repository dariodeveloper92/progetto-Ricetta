package com.example.testapplicazione.response;

import org.springframework.http.HttpStatus;

public class Response {
    private String message;

    public Response(HttpStatus ok, String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.kncm.accountservice.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String title;

    public ErrorResponse() {
        this.title = "Accommodation booker application";
    }
}

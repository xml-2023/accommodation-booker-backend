package com.kncm.accommodationservice.handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidDateFormatException extends RuntimeException{

    public InvalidDateFormatException(){
        super();
    }
}

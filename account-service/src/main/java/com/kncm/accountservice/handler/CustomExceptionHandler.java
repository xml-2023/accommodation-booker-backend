package com.kncm.accountservice.handler;

import com.kncm.accountservice.handler.exceptions.UsernameIsNotUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameIsNotUniqueException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUsernameIsNotUniqueException(UsernameIsNotUniqueException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Username must be unique");
        return errorResponse;
    }
}

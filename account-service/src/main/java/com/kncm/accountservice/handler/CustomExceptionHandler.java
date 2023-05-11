package com.kncm.accountservice.handler;

import com.kncm.accountservice.handler.exceptions.UserDetailsRequestIsNotValidException;
import com.kncm.accountservice.handler.exceptions.UserWithPassedIdDoesNotExistException;
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

    @ExceptionHandler(UserWithPassedIdDoesNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUserWithPassedIdDoesNotExistException(UserWithPassedIdDoesNotExistException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("User with passed id does not exist");
        return errorResponse;
    }

    @ExceptionHandler(UserDetailsRequestIsNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUserDetailsRequestIsNotValidException(UserDetailsRequestIsNotValidException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("All attributes must have value");
        return errorResponse;
    }
}

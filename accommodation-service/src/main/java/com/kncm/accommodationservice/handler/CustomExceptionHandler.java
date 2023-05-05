package com.kncm.accommodationservice.handler;

import com.kncm.accommodationservice.handler.exceptions.CreateAccommodationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CreateAccommodationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleCreateAccommodationException(CreateAccommodationException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Error while creating accommodation!");
        return errorResponse;
    }
}

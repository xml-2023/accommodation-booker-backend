package com.kncm.accommodationservice.handler;

import com.kncm.accommodationservice.handler.exceptions.*;
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

    @ExceptionHandler(InvalidDateFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInvalidDateFormatException(InvalidDateFormatException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Cannot parse date!");
        return errorResponse;
    }

    @ExceptionHandler(CreateAvailabilityException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleCreateAvailabilityException(CreateAvailabilityException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Error while creating accommodation availability slot");
        return errorResponse;
    }

    @ExceptionHandler(AccommodationIsNullException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleAccommodationIsNullException(AccommodationIsNullException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Accommodation does not exist!");
        return errorResponse;
    }

    @ExceptionHandler(AvailabilityIsNullException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleAvailabilityIsNullException(AvailabilityIsNullException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Available slot does not exist!");
        return errorResponse;
    }
}

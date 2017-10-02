package com.app.projet.ExceptionController;

import com.app.projet.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(StockNegatifException.class)
    @ResponseStatus( HttpStatus.NOT_ACCEPTABLE)
    public String handleException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(ClientAlreadyExisting.class)
    @ResponseStatus( HttpStatus.NOT_ACCEPTABLE)
    public String clientAlreadyExistingHandleException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_ACCEPTABLE)
    public String clientNotFoundHandleException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(OrgUndeletableException.class)
    @ResponseStatus( HttpStatus.NOT_ACCEPTABLE)
    public String orgUndeletableHandleException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(EmptyResponseException.class)
    @ResponseStatus( HttpStatus.NOT_ACCEPTABLE)
    public String emptyResponseHandleException(Exception e){
        return e.getMessage();
    }
}

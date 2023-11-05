package com.DH.apiuser.util.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends Exception{
    public ResourceNotFoundExceptions(String message) {
        //not found category
        super(message);
    }

}

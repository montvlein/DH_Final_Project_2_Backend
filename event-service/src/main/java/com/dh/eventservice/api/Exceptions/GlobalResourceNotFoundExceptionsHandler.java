package com.dh.eventservice.api.Exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResourceNotFoundExceptionsHandler {
    private static final Logger logger= Logger.getLogger(GlobalResourceNotFoundExceptionsHandler.class);

    @ExceptionHandler({ResourceNotFoundExceptions.class})
    public ResponseEntity<?> erroresNotFound(ResourceNotFoundExceptions e){
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}

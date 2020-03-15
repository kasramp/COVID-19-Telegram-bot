package com.madadipouya.telegram.corona.general.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> unknownException(Exception ex) {
        logger.error(getStackTrace(ex));
        return ResponseEntity.ok("OK!");
    }
}
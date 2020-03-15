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
public class ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
    private static final String ERR_UNABLE_TO_PROCESS_REQUEST = "Unable to process the request!";

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CurrentWeatherCondition> unknownException(Exception ex) {
        logger.error(getStackTrace(ex));
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new CurrentWeatherCondition(List.of(ERR_UNABLE_TO_PROCESS_REQUEST)));
    }
}
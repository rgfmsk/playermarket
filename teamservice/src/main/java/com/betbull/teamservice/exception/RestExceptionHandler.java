package com.betbull.teamservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorModel handle(TeamNotFoundException ex) {
        logger.error(ex.getMessage(), ex);
        return new ErrorModel(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorModel handle(PlayerNotFoundException ex) {
        logger.error(ex.getMessage(), ex);
        return new ErrorModel(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(TransferNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorModel handle(TransferNotFoundException ex) {
        logger.error(ex.getMessage(), ex);
        return new ErrorModel(ex.getCode(), ex.getMessage());
    }
}
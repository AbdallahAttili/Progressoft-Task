package com.fxDeals.progresSoft.progresSoftApplication.handler;

import com.fxDeals.progresSoft.progresSoftApplication.exception.DealNotFoundException;
import com.fxDeals.progresSoft.progresSoftApplication.exception.InvalidDealDetailsException;
import com.fxDeals.progresSoft.progresSoftApplication.pojo.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler class for centralizing exception handling and response customization
 * across the application.
 * <p>
 * This class extends {@link ResponseEntityExceptionHandler} to provide additional common
 * handling mechanisms for Spring MVC exceptions. It is annotated with {@code @RestControllerAdvice}
 * to allow it to be auto-detected through classpath scanning and applied to all controllers.
 * </p>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, "Validation failed", errorList);

        return this.handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
    }

    @ExceptionHandler(DealNotFoundException.class)
    protected ErrorDetails handleDealNotFoundException(DealNotFoundException ex) {
        return new ErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler(InvalidDealDetailsException.class)
    protected ErrorDetails handleInvalidDealDetailsException(InvalidDealDetailsException ex) {
        return new ErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }
}

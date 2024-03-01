package com.fxDeals.progresSoft.progresSoftApplication.exception;

public class DealAlreadyExistException extends RuntimeException {
    public DealAlreadyExistException() {
    }

    public DealAlreadyExistException(String message) {
        super(message);
    }
}

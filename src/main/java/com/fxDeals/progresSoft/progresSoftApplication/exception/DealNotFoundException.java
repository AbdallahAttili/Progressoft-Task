package com.fxDeals.progresSoft.progresSoftApplication.exception;

public class DealNotFoundException extends RuntimeException {
    public DealNotFoundException() {
    }

    public DealNotFoundException(String message) {
        super(message);
    }
}

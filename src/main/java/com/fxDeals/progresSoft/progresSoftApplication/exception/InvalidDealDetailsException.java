package com.fxDeals.progresSoft.progresSoftApplication.exception;

/**
 * Custom exception class for handling scenarios where deal details are found to be invalid.
 * <p>
 * This exception is thrown when an operation related to processing or validating
 * deal transactions encounters details that are either incorrect, incomplete, or do not
 * meet the predefined criteria for a valid deal.
 * </p>
 */
public class InvalidDealDetailsException extends RuntimeException {

    /**
     * Constructs a new InvalidDealDetailsException without a detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public InvalidDealDetailsException() {
        super();
    }

    /**
     * Constructs a new InvalidDealDetailsException with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later
     *                retrieval by the {@link #getMessage()} method.
     */
    public InvalidDealDetailsException(String message) {
        super(message);
    }
}

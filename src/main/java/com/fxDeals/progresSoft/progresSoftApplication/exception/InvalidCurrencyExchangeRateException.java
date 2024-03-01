package com.fxDeals.progresSoft.progresSoftApplication.exception;

/**
 * Custom exception class for handling invalid currency exchange rate scenarios.
 * <p>
 * This exception is thrown when an operation involving currency exchange rates
 * encounters an invalid or unacceptable value, such as an exchange rate that does
 * not exist or is not applicable for the given currency pair.
 * </p>
 */
public class InvalidCurrencyExchangeRateException extends RuntimeException {

    /**
     * Constructs a new InvalidCurrencyExchangeRateException with {@code null} as its
     * detail message. The cause is not initialized.
     */
    public InvalidCurrencyExchangeRateException() {
        super();
    }

    /**
     * Constructs a new InvalidCurrencyExchangeRateException with the specified detail message.
     * The cause is not initialized.
     *
     * @param message the detail message. The detail message is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method.
     */
    public InvalidCurrencyExchangeRateException(String message) {
        super(message);
    }
}

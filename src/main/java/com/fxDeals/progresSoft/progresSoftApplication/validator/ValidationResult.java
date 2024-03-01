package com.fxDeals.progresSoft.progresSoftApplication.validator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the outcome of a validation operation.
 * <p>
 * This class encapsulates the result of a validation process, indicating whether
 * the validation was successful and providing an associated message if it was not.
 * The static factory methods {@code ok} and {@code fail} offer a convenient way
 * to create instances for common scenarios.
 * </p>
 */
@Data
@AllArgsConstructor
public class ValidationResult {
    /**
     * Indicates the validity of the validation. {@code true} if the validation
     * passed, {@code false} otherwise.
     */
    private final boolean valid;

    /**
     * Provides additional details about the validation outcome, particularly useful
     * when validation fails. This field is typically {@code null} when {@code valid}
     * is {@code true}.
     */
    private final String message;

    /**
     * Creates a successful validation result without an error message.
     *
     * @return A {@code ValidationResult} indicating a successful validation.
     */
    public static ValidationResult ok() {
        return new ValidationResult(true, null);
    }

    /**
     * Creates a failed validation result with the specified error message.
     *
     * @param message The error message detailing why the validation failed.
     * @return A {@code ValidationResult} indicating a failed validation.
     */
    public static ValidationResult fail(String message) {
        return new ValidationResult(false, message);
    }
}

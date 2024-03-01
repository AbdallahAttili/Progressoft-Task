package com.fxDeals.progresSoft.progresSoftApplication.validator;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;

import java.util.Objects;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_CANNOT_BE_NULL;

/**
 * Abstract base class for deal validation.
 * <p>
 * Provides a template method {@code validate} that ensures the deal object is not null
 * before delegating to the specific validation logic implemented by subclasses. This
 * approach allows for common pre-validation checks to be centralized and for different
 * aspects of a deal to be validated by extending this class and implementing the
 * {@code performValidation} method.
 * </p>
 */
public abstract class DealValidator {

    /**
     * Validates a deal object.
     * <p>
     * Performs a non-null check on the deal object before delegating to the specific
     * validation logic defined in {@code performValidation}. This ensures that all deal
     * validators uniformly handle null checks.
     * </p>
     *
     * @param deal The deal object to be validated.
     * @return A {@link ValidationResult} indicating the outcome of the validation. Returns
     * a failure result if the deal is null, otherwise delegates to {@code performValidation}.
     */
    public ValidationResult validate(Deal deal) {
        if (Objects.isNull(deal)) {
            return ValidationResult.fail(DEAL_CANNOT_BE_NULL);
        }

        return performValidation(deal);
    }

    /**
     * Specific validation logic to be implemented by subclasses.
     * <p>
     * This method defines how the validation should be performed for the specific aspect
     * of the deal being checked. Implementations should return a {@link ValidationResult}
     * indicating the outcome of the validation.
     * </p>
     *
     * @param deal The deal object to be validated.
     * @return A {@link ValidationResult} indicating the outcome of the validation.
     */
    protected abstract ValidationResult performValidation(Deal deal);
}

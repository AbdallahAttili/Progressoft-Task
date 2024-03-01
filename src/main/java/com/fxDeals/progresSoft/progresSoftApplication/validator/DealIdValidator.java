package com.fxDeals.progresSoft.progresSoftApplication.validator;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_ID_CANNOT_BE_NULL;
import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_ID_CANNOT_BE_ZERO_OR_NEGATIVE;

/**
 * Validator component for validating the deal ID in {@link Deal} entities.
 * <p>
 * This validator checks if the deal ID is not null and ensures that it is a positive number,
 * signifying a valid and existing deal. It extends {@link DealValidator} to provide specific
 * validation logic for the deal ID.
 * </p>
 */
@Component
public class DealIdValidator extends DealValidator {

    /**
     * Performs validation on the deal ID.
     * <p>
     * Validates that the deal ID is not null and is greater than zero. If the validation
     * fails, it returns a {@link ValidationResult} indicating failure and the reason for it.
     * Otherwise, it returns a success {@link ValidationResult}.
     * </p>
     *
     * @param deal The {@link Deal} entity whose ID is to be validated.
     * @return A {@link ValidationResult} indicating whether the validation succeeded or failed.
     */
    @Override
    public ValidationResult performValidation(Deal deal) {
        if (Objects.isNull(deal.getDealId())) {
            return ValidationResult.fail(DEAL_ID_CANNOT_BE_NULL);
        }

        if (deal.getDealId() <= 0) {
            return ValidationResult.fail(DEAL_ID_CANNOT_BE_ZERO_OR_NEGATIVE);
        }

        return ValidationResult.ok();
    }
}

package com.fxDeals.progresSoft.progresSoftApplication.validator;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_AMOUNT_CANNOT_BE_NULL;
import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_AMOUNT_CANNOT_BE_ZERO_OR_NEGATIVE;

/**
 * Validator component for validating the deal amount in {@link Deal} entities.
 * <p>
 * This validator checks if the deal ordering amount is not null and ensures that
 * it is greater than zero. It extends {@link DealValidator} to provide specific
 * validation logic for the deal amount.
 * </p>
 */
@Component
public class DealAmountValidator extends DealValidator {

    /**
     * Performs validation on the deal amount.
     * <p>
     * Validates that the deal amount is not null and is greater than zero. If the validation
     * fails, it returns a {@link ValidationResult} indicating failure and the reason for it.
     * Otherwise, it returns a success {@link ValidationResult}.
     * </p>
     *
     * @param deal The {@link Deal} entity whose amount is to be validated.
     * @return A {@link ValidationResult} indicating whether the validation succeeded or failed.
     */
    @Override
    public ValidationResult performValidation(Deal deal) {
        if (Objects.isNull(deal.getDealOrderingAmount())) {
            return ValidationResult.fail(DEAL_AMOUNT_CANNOT_BE_NULL);
        }

        if (deal.getDealOrderingAmount() <= 0) {
            return ValidationResult.fail(DEAL_AMOUNT_CANNOT_BE_ZERO_OR_NEGATIVE);
        }

        return ValidationResult.ok();
    }
}

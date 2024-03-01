package com.fxDeals.progresSoft.progresSoftApplication.validator;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_DATE_TIMESTAMP_CANNOT_BE_NULL;

/**
 * Validator component for validating the date timestamp of {@link Deal} entities.
 * <p>
 * This validator ensures that the deal has a valid timestamp indicating when the deal
 * was made. It extends {@link DealValidator} to provide specific validation logic
 * for the deal timestamp.
 * </p>
 */
@Component
public class DealDateTimestampValidator extends DealValidator {

    /**
     * Performs validation on the date timestamp of a deal.
     * <p>
     * Validates that the deal timestamp is not null. If the deal timestamp is null,
     * it returns a {@link ValidationResult} indicating failure and the reason for it.
     * Otherwise, it returns a success {@link ValidationResult}.
     * </p>
     *
     * @param deal The {@link Deal} entity whose date timestamp is to be validated.
     * @return A {@link ValidationResult} indicating whether the validation succeeded or failed.
     */
    @Override
    public ValidationResult performValidation(Deal deal) {
        if (Objects.isNull(deal.getDealTimestamp())) {
            return ValidationResult.fail(DEAL_DATE_TIMESTAMP_CANNOT_BE_NULL);
        }

        return ValidationResult.ok();
    }
}

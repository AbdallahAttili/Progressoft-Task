package com.fxDeals.progresSoft.progresSoftApplication.validator;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.DEAL_CURRENCY_ISO_CODE_CANNOT_BE_NULL;

/**
 * Validator component for validating the currency ISO codes in {@link Deal} entities.
 * <p>
 * This validator ensures that both the 'from' and 'to' currency ISO codes in a deal
 * are not null, ensuring that every deal has a valid source and destination currency.
 * It extends {@link DealValidator} to implement specific validation logic for currency
 * ISO codes.
 * </p>
 */
@Component
public class DealCurrencyValidator extends DealValidator {

    /**
     * Performs validation on the currency ISO codes of a deal.
     * <p>
     * Checks that both 'from' and 'to' currency ISO codes are not null. If either of the
     * currency ISO codes is null, it returns a {@link ValidationResult} indicating failure
     * and the reason for it. Otherwise, it returns a success {@link ValidationResult}.
     * </p>
     *
     * @param deal The {@link Deal} entity whose currency ISO codes are to be validated.
     * @return A {@link ValidationResult} indicating whether the validation succeeded or failed.
     */
    @Override
    public ValidationResult performValidation(Deal deal) {
        if (Objects.isNull(deal.getFromCurrencyIsoCode()) || Objects.isNull(deal.getToCurrencyIsoCode())) {
            return ValidationResult.fail(DEAL_CURRENCY_ISO_CODE_CANNOT_BE_NULL);
        }

        return ValidationResult.ok();
    }
}

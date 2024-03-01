package com.fxDeals.progresSoft.progresSoftApplication.service;

import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages;
import com.fxDeals.progresSoft.progresSoftApplication.dao.CurrencyExchangeRateRepository;
import com.fxDeals.progresSoft.progresSoftApplication.dao.DealRepository;
import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRate;
import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRatePK;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import com.fxDeals.progresSoft.progresSoftApplication.exception.DealAlreadyExistException;
import com.fxDeals.progresSoft.progresSoftApplication.exception.DealNotFoundException;
import com.fxDeals.progresSoft.progresSoftApplication.exception.InvalidCurrencyExchangeRateException;
import com.fxDeals.progresSoft.progresSoftApplication.exception.InvalidDealDetailsException;
import com.fxDeals.progresSoft.progresSoftApplication.validator.DealValidator;
import com.fxDeals.progresSoft.progresSoftApplication.validator.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fxDeals.progresSoft.progresSoftApplication.constant.ExceptionMessages.*;

/**
 * Service implementation for managing deals.
 * <p>
 * Provides business logic for deal operations including validation and persistence.
 * Utilizes {@link DealRepository} for database access, {@link CurrencyExchangeRateRepository}
 * for retrieving exchange rates, and {@link DealValidator}s for deal validation.
 * </p>
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private CurrencyExchangeRateRepository currencyExchangeRateRepository;

    @Autowired
    private List<DealValidator> dealValidators;

    /**
     * Adds a new deal to the database after validating it and calculating the target amount
     * based on the current exchange rate.
     * <p>
     * Throws {@link InvalidDealDetailsException} if validation fails or
     * {@link InvalidCurrencyExchangeRateException} if no matching exchange rate is found.
     * </p>
     *
     * @param newDeal The {@link Deal} entity to be added.
     */
    @Override
    public void addDeal(Deal newDeal) {
        Optional<ValidationResult> validationResult = validateDeal(newDeal);

        if (validationResult.isPresent()) {
            throw new InvalidDealDetailsException(validationResult.get().getMessage());
        }

        if (dealRepository.existsById(newDeal.getDealId())) {
            throw new DealAlreadyExistException(DEAL_ALREADY_EXIST_EXCEPTION);
        }

        Double exchangeRate = getExchangeRate(newDeal.getFromCurrencyIsoCode(), newDeal.getToCurrencyIsoCode());

        newDeal.setDealTargetAmount(newDeal.getDealOrderingAmount() * exchangeRate);

        dealRepository.save(newDeal);
    }

    @Override
    public Deal getDealById(Long dealId) {
        return dealRepository.findById(dealId)
                             .orElseThrow(() -> new DealNotFoundException(DEAL_NOT_FOUND));
    }

    @Override
    public List<Deal> getAllDeals() {
        List<Deal> deals = new ArrayList<>();

        dealRepository.findAll().forEach(deals::add);

        return deals;
    }

    /**
     * Validates the deal using registered {@link DealValidator}s.
     *
     * @param newDeal The {@link Deal} entity to validate.
     * @return An {@link Optional} containing {@link ValidationResult} if validation fails.
     */
    private Optional<ValidationResult> validateDeal(Deal newDeal) {
        return dealValidators.stream()
                .map(dealValidator -> dealValidator.validate(newDeal))
                .filter(validationResult -> !validationResult.isValid())
                .findFirst();
    }

    /**
     * Retrieves the exchange rate for a given currency pair.
     *
     * @param fromCurrencyIsoCode The source currency ISO code.
     * @param toCurrencyIsoCode   The target currency ISO code.
     * @return The exchange rate.
     * @throws InvalidCurrencyExchangeRateException if no matching exchange rate is found.
     */
    private Double getExchangeRate(CurrencyIsoCode fromCurrencyIsoCode, CurrencyIsoCode toCurrencyIsoCode) {
        CurrencyExchangeRatePK currencyExchangeRatePK = new CurrencyExchangeRatePK(fromCurrencyIsoCode, toCurrencyIsoCode);

        Optional<CurrencyExchangeRate> currencyExchangeRate = currencyExchangeRateRepository.findById(currencyExchangeRatePK);

        if (currencyExchangeRate.isEmpty()) {
            // Consider adding logging here to record when no exchange rate is found
            throw new InvalidCurrencyExchangeRateException(NO_MATCHED_CURRENCY_EXCHANGE_RATE);
        }

        return currencyExchangeRate.get().getExchangeRate();
    }
}

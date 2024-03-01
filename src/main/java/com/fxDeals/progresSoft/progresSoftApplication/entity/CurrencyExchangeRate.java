package com.fxDeals.progresSoft.progresSoftApplication.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing the exchange rate between two currencies.
 * <p>
 * This entity stores information about the exchange rate for a specific currency pair,
 * identified by a composite primary key {@link CurrencyExchangeRatePK}, which includes
 * the from and to currency ISO codes. The exchange rate represents the rate at which
 * one currency will be exchanged for another.
 * </p>
 */
@Entity
@Table(name = "currency_exchange_rate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyExchangeRate {

    /**
     * The composite primary key for this entity, representing the currency pair
     * for which the exchange rate is defined.
     */
    @EmbeddedId
    private CurrencyExchangeRatePK currencyExchangeRatePK;

    /**
     * The exchange rate for the currency pair. This is the rate at which the
     * 'from' currency can be exchanged for the 'to' currency.
     */
    @Column(name = "exchange_rate")
    private Double exchangeRate;
}

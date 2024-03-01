package com.fxDeals.progresSoft.progresSoftApplication.entity;

import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Embeddable primary key class for {@link CurrencyExchangeRate} entity.
 * <p>
 * This class represents the composite primary key of the currency exchange rate entity,
 * consisting of the 'from' and 'to' currency ISO codes, using the {@link CurrencyIsoCode} enum.
 * It implements {@link Serializable} to support JPA caching and to be safely used in
 * serialized form.
 * </p>
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyExchangeRatePK implements Serializable {

    /**
     * Serial version UID for serialization.
     */
    private static final long serialVersionUID = 6202269445639364170L;

    /**
     * The ISO code of the currency from which exchange is being made.
     * <p>
     * It is stored as a string in the database but represented using the {@link CurrencyIsoCode}
     * enum in the application.
     * </p>
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "from_currency")
    private CurrencyIsoCode fromCurrencyIsoCode;

    /**
     * The ISO code of the currency to which exchange is being made.
     * <p>
     * Similar to {@code fromCurrencyIsoCode}, it is stored as a string in the database
     * but represented using the {@link CurrencyIsoCode} enum in the application.
     * </p>
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "to_currency")
    private CurrencyIsoCode toCurrencyIsoCode;
}

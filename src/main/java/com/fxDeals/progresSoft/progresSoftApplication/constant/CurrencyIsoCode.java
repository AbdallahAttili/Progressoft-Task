package com.fxDeals.progresSoft.progresSoftApplication.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enum representing the ISO 4217 currency codes supported by the application.
 * <p>
 * This enum includes a subset of globally recognized currencies, providing
 * a standardized way to reference them throughout the application.
 * </p>
 */
public enum CurrencyIsoCode {
    /**
     * The United States Dollar.
     */
    USD,

    /**
     * The Euro used by countries in the European Union.
     */
    EUR,

    /**
     * The Japanese Yen.
     */
    JPY,

    /**
     * The British Pound Sterling.
     */
    GBP,

    /**
     * The Australian Dollar.
     */
    AUD,

    /**
     * The Canadian Dollar.
     */
    CAD;

    @JsonCreator
    public static CurrencyIsoCode forName(String name) {
        for(CurrencyIsoCode c: values()) {
            if(c.name().equals(name)) { //change accordingly
                return c;
            }
        }

        return null;
    }
}

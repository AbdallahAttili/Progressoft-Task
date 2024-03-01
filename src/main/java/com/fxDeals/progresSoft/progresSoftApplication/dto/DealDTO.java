package com.fxDeals.progresSoft.progresSoftApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object representing a deal.
 * <p>
 * This DTO encapsulates the data for a deal transaction, including details
 * such as the deal ID, currency ISO codes for the source and destination currencies,
 * the timestamp of the deal, and the amount being transferred.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDTO {

    /**
     * The unique identifier for the deal.
     */
    @NotNull(message = "dealId cannot be null!")
    private Long dealId;

    /**
     * The ISO currency code for the currency from which the amount is being transferred.
     */
    @NotNull(message = "fromCurrencyIsoCode cannot be null!")
    private CurrencyIsoCode fromCurrencyIsoCode;

    /**
     * The ISO currency code for the currency to which the amount is being transferred.
     */
    @NotNull(message = "toCurrencyIsoCode cannot be null!")
    private CurrencyIsoCode toCurrencyIsoCode;

    /**
     * The timestamp indicating when the deal was made.
     * <p>
     * This is formatted as a string according to the ISO-8601 standard.
     * </p>
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dealTimestamp;

    /**
     * The amount being transferred in the deal.
     * <p>
     * This value is required to be positive, indicating a movement of funds
     * from the source to the destination currency.
     * </p>
     */
    @Positive(message = "dealOrderingAmount cannot be zero or negative!")
    private Double dealOrderingAmount;
}

package com.fxDeals.progresSoft.progresSoftApplication.entity;

import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Entity representing a financial deal transaction.
 * <p>
 * This entity encapsulates all the necessary details of a currency exchange deal,
 * including the currencies involved, the timestamp of the deal, and the amounts
 * being exchanged.
 * </p>
 */
@Entity
@Table(name = "deal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Deal {

    /**
     * Unique identifier for the deal.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private Long dealId;

    /**
     * ISO code of the currency from which the amount is being transferred.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "from_currency_iso_code")
    private CurrencyIsoCode fromCurrencyIsoCode;

    /**
     * ISO code of the currency to which the amount is being transferred.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "to_currency_iso_code")
    private CurrencyIsoCode toCurrencyIsoCode;

    /**
     * Timestamp indicating when the deal was made.
     */
    @Column(name = "deal_timestamp")
    private LocalDateTime dealTimestamp;

    /**
     * The amount being transferred in the deal from the source currency.
     */
    @Column(name = "deal_ordering_amount")
    private Double dealOrderingAmount;

    /**
     * The target amount expected to be received in the deal's target currency,
     * calculated based on the exchange rate at the time of the deal.
     */
    @Column(name = "deal_target_amount")
    private Double dealTargetAmount;
}

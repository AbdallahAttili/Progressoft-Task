package com.fxDeals.progresSoft.progresSoftApplication.common;

import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import com.fxDeals.progresSoft.progresSoftApplication.dto.DealDTO;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;

import java.time.LocalDateTime;

public class TestBase {
    protected Deal getDealObject() {
        return Deal.builder()
                .dealId(1L)
                .fromCurrencyIsoCode(CurrencyIsoCode.EUR)
                .toCurrencyIsoCode(CurrencyIsoCode.USD)
                .dealOrderingAmount(100.0)
                .dealTimestamp(LocalDateTime.now())
                .build();
    }

    protected DealDTO getDealDTOObject() {
        return DealDTO.builder()
                .dealId(1L)
                .fromCurrencyIsoCode(CurrencyIsoCode.EUR)
                .toCurrencyIsoCode(CurrencyIsoCode.USD)
                .dealOrderingAmount(200.0)
                .dealTimestamp(LocalDateTime.now())
                .build();
    }
}

package com.fxDeals.progresSoft.progresSoftApplication.service;

import com.fxDeals.progresSoft.progresSoftApplication.common.TestBase;
import com.fxDeals.progresSoft.progresSoftApplication.constant.CurrencyIsoCode;
import com.fxDeals.progresSoft.progresSoftApplication.dao.CurrencyExchangeRateRepository;
import com.fxDeals.progresSoft.progresSoftApplication.dao.DealRepository;
import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRate;
import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRatePK;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import com.fxDeals.progresSoft.progresSoftApplication.exception.DealNotFoundException;
import com.fxDeals.progresSoft.progresSoftApplication.exception.InvalidDealDetailsException;
import com.fxDeals.progresSoft.progresSoftApplication.validator.DealValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DealServiceImplTest extends TestBase {

    @Autowired
    private DealServiceImpl dealService;

    @MockBean
    private DealRepository dealRepository;

    @MockBean
    private CurrencyExchangeRateRepository currencyExchangeRateRepository;

    @Autowired
    private List<DealValidator> dealValidators;

    @Before
    public void setup() {
        CurrencyExchangeRatePK currencyExchangeRatePK = new CurrencyExchangeRatePK(CurrencyIsoCode.EUR, CurrencyIsoCode.USD);
        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate(currencyExchangeRatePK, 1.10);

        Mockito.when(currencyExchangeRateRepository.findById(currencyExchangeRatePK))
               .thenReturn(Optional.of(currencyExchangeRate));

        Mockito.when(dealRepository.findById(1L)).thenReturn(Optional.of(getDealObject()));
        Mockito.when(dealRepository.findAll()).thenReturn(List.of(getDealObject()));
    }

    @Test
    public void testAddNullableDealThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = null;
        
        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealHappyCase() {
        Deal dealObject = getDealObject();

        dealService.addDeal(dealObject);
    }
    
    @Test
    public void testAddDealWhenDealAmountIsZeroThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealOrderingAmount(0.0);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal amount cannot be zero or negative!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealAmountIsLessThanZeroThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealOrderingAmount(-10.0);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal amount cannot be zero or negative!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealAmountIsNullThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealOrderingAmount(null);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal amount cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealFromCurrencyIsNullThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setFromCurrencyIsoCode(null);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal currency ISO codes cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealToCurrencyIsNullThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setFromCurrencyIsoCode(null);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal currency ISO codes cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealDateTimestampIsNullThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealTimestamp(null);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal date timestamp cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealIdIsNullThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealId(null);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal Id cannot be null!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testAddDealWhenDealIdIsInMinusThenInvalidDealDetailsExceptionShouldBeThrown() {
        Deal dealObject = getDealObject();

        dealObject.setDealId(-1L);

        InvalidDealDetailsException invalidDealDetailsException = Assert.
                                assertThrows(InvalidDealDetailsException.class, () -> dealService.addDeal(dealObject));

        Assert.assertEquals("Deal Id cannot be zero or negative!", invalidDealDetailsException.getMessage());
    }

    @Test
    public void testGetDealByExistingIdThenDealShouldBeReturned() {
        Deal deal = dealService.getDealById(1L);

        Assert.assertTrue(Objects.nonNull(deal));
    }

    @Test(expected = DealNotFoundException.class)
    public void testGetDealByNonExistingIdThenDealNotFoundExceptionShouldBeThrown() {
        Deal deal = dealService.getDealById(10L);
    }

    @Test
    public void testGetAllDealsThenDealsListShouldBeReturned() {
        List<Deal> allDeals = dealService.getAllDeals();

        Assert.assertFalse(allDeals.isEmpty());
    }
}

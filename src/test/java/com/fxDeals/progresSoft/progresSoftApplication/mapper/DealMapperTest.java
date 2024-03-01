package com.fxDeals.progresSoft.progresSoftApplication.mapper;

import com.fxDeals.progresSoft.progresSoftApplication.common.TestBase;
import com.fxDeals.progresSoft.progresSoftApplication.dto.DealDTO;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DealMapperTest extends TestBase {
    private static final DealMapper MAPPER = Mappers.getMapper(DealMapper.class);

    @Test
    public void testMappingDealDTOToDealEntityThenMappingShouldSucceed() {
        DealDTO dealDTOObject = getDealDTOObject();

        Deal deal = MAPPER.fromDTO(dealDTOObject);

        Assert.assertEquals(dealDTOObject.getDealId(), deal.getDealId());
        Assert.assertEquals(dealDTOObject.getToCurrencyIsoCode(), deal.getToCurrencyIsoCode());
        Assert.assertEquals(dealDTOObject.getFromCurrencyIsoCode(), deal.getFromCurrencyIsoCode());
        Assert.assertEquals(dealDTOObject.getDealOrderingAmount(), deal.getDealOrderingAmount());
        Assert.assertEquals(dealDTOObject.getDealTimestamp(), deal.getDealTimestamp());
    }
}

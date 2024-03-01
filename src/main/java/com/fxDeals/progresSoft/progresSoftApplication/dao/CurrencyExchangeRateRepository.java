package com.fxDeals.progresSoft.progresSoftApplication.dao;

import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRate;
import com.fxDeals.progresSoft.progresSoftApplication.entity.CurrencyExchangeRatePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link CurrencyExchangeRate} entities.
 * <p>
 * This interface extends Spring Data's {@link CrudRepository}, providing
 * default CRUD operations for {@link CurrencyExchangeRate} entities without
 * the need for implementing these methods. It operates on {@link CurrencyExchangeRate}
 * entities with a primary key of type {@link CurrencyExchangeRatePK}.
 * </p>
 * <p>
 * Use this repository to interact with the underlying database through
 * Spring Data JPA's abstraction for common data access patterns. It
 * simplifies the data access layer by eliminating boilerplate CRUD
 * operations and enabling the easy implementation of complex queries.
 * </p>
 */
@Repository
public interface CurrencyExchangeRateRepository extends CrudRepository<CurrencyExchangeRate, CurrencyExchangeRatePK> {
}

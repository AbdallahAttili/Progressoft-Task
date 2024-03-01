package com.fxDeals.progresSoft.progresSoftApplication.dao;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for handling CRUD operations for {@link Deal} entities.
 * <p>
 * Utilizes Spring Data JPA to abstract the data layer implementation, providing
 * a simplified mechanism for data access and manipulation. This repository
 * supports creating, reading, updating, and deleting {@link Deal} entities,
 * with each {@link Deal} identified by a unique identifier of type {@link Long}.
 * </p>
 */
@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {
}

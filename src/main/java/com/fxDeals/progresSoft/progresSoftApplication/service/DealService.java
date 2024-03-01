package com.fxDeals.progresSoft.progresSoftApplication.service;

import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;

import java.util.List;

/**
 * Service interface for managing deals within the application.
 * <p>
 * Defines the contract for services that handle operations related to deals,
 * such as adding new deals to the database. This interface is intended to be
 * implemented by classes that provide the business logic associated with deal
 * transactions.
 * </p>
 */
public interface DealService {

    /**
     * Adds a new deal to the system.
     * <p>
     * This method is responsible for persisting the provided {@link Deal} entity
     * to the database, including any necessary validation or preprocessing required
     * before saving. Implementations should ensure that all business rules and
     * constraints related to deal creation are enforced.
     * </p>
     *
     * @param newDeal The {@link Deal} entity to be added. Must not be {@code null}.
     */
    void addDeal(Deal newDeal);

    Deal getDealById(Long dealId);

    List<Deal> getAllDeals();
}

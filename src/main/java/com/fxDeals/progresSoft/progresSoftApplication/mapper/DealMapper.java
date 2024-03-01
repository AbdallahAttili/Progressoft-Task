package com.fxDeals.progresSoft.progresSoftApplication.mapper;

import com.fxDeals.progresSoft.progresSoftApplication.dto.DealDTO;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting between {@link DealDTO} and {@link Deal} entities.
 * <p>
 * Utilizes MapStruct to generate implementation code automatically at compile time,
 * providing a type-safe way to convert between DTO and entity objects. This mapper is
 * declared as a Spring component, allowing it to be injected into other components
 * and services in the application.
 * </p>
 */
@Mapper(componentModel = "spring")
public interface DealMapper {

    /**
     * Converts a {@link DealDTO} to a {@link Deal} entity.
     * <p>
     * This method maps data from a DealDTO object to a Deal entity, facilitating
     * the transfer of data from API layer objects to database entities.
     * </p>
     *
     * @param dealDTO the DTO object containing deal data.
     * @return a {@link Deal} entity populated with data from the provided DTO.
     */
    Deal fromDTO(DealDTO dealDTO);

    DealDTO toDTO(Deal deal);

    List<DealDTO> toDTOList(List<Deal> deals);
}

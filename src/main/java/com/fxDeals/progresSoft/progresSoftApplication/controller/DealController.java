package com.fxDeals.progresSoft.progresSoftApplication.controller;

import com.fxDeals.progresSoft.progresSoftApplication.dto.DealDTO;
import com.fxDeals.progresSoft.progresSoftApplication.entity.Deal;
import com.fxDeals.progresSoft.progresSoftApplication.mapper.DealMapper;
import com.fxDeals.progresSoft.progresSoftApplication.service.DealService;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing deals within the application.
 * <p>
 * This controller provides endpoints for adding and managing deal entities.
 * It utilizes {@link DealService} for business logic and {@link DealMapper}
 * for converting between DTO and entity representations.
 * </p>
 */
@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @Autowired
    private DealMapper dealMapper;

    private static final DealMapper MAPPER = Mappers.getMapper(DealMapper.class);

    /**
     * Adds a new deal to the application.
     * <p>
     * This endpoint accepts a deal in its DTO form, converts it to an entity,
     * and persists it through the {@link DealService}. It validates the incoming
     * DTO to ensure it meets the expected format and required fields.
     * </p>
     *
     * @param newDeal the deal information to add, in DTO form, must not be null.
     * @return a {@link ResponseEntity} indicating the outcome of the operation.
     */
    @PostMapping("/add-deal")
    public ResponseEntity<?> addDeal(@Valid @RequestBody DealDTO newDeal) {
        Deal deal = MAPPER.fromDTO(newDeal);

        dealService.addDeal(deal);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{dealId}")
    public ResponseEntity<DealDTO> getDealById(@PathVariable Long dealId) {
        Deal deal = dealService.getDealById(dealId);

        DealDTO dealDTO = MAPPER.toDTO(deal);

        return ResponseEntity.ok().body(dealDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllDeals() {
        List<Deal> allDeals = dealService.getAllDeals();

        List<DealDTO> dealDTOList = MAPPER.toDTOList(allDeals);

        return ResponseEntity.ok().body(dealDTOList);
    }
}

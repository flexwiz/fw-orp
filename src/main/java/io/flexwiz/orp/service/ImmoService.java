package io.flexwiz.orp.service;

import io.flexwiz.orp.dto.CreateRealEstateRequest;
import io.flexwiz.orp.dto.RealEstateDto;

import java.util.List;

public interface OrpService {

    /**
     * Create a new realEstate
     * @param request  new realEstate creation request
     * @return id of created realEstate
     */
    Long create(CreateRealEstateRequest request);

    /**
     * Get a user realEstates
     * @param userId  expected realEstate ownerId
     * @return list of the user realEstate
     */
    List<RealEstateDto> allByUser(Long userId);

    /**
     * Get a realEstate by its id
     * @param userId expected realEstate ownerId
     * @param id  expected realEstate id
     * @return return a realEstate
     */
    RealEstateDto byId(Long id, Long userId);
}

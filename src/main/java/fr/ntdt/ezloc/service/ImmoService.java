package fr.ntdt.ezloc.service;

import fr.ntdt.ezloc.dto.CreateRealEstateRequest;
import fr.ntdt.ezloc.dto.RealEstateDto;

import java.util.List;

public interface ImmoService {

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

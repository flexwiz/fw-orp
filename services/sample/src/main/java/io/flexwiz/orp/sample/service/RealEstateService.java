package io.flexwiz.orp.sample.service;

import io.flexwiz.orp.sample.service.dto.RealEstate;
import io.flexwiz.orp.sample.service.mapper.RealEstateMapper;
import io.flexwiz.orp.sample.spi.data.IRealEstateRepository;
import io.flexwiz.orp.sample.spi.data.entity.RealEstateEntity;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class RealEstateService {

    private static final org.slf4j.Logger log
		= org.slf4j.LoggerFactory.getLogger(RealEstateService.class);

    private final IRealEstateRepository repository;
    private final RealEstateMapper mapper;

    @Autowired
    public RealEstateService(IRealEstateRepository repository, RealEstateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Creates a new real estate from the given 'CreateRealEstate' command.
     *
     * @param userId an not null user ID
     * @param realEstateDto an not null real estate to create
     * @return an ID of the saved real estate
     * @throws RealEstateServiceException
     */
    public UUID createRealEstate(UUID userId, RealEstate realEstateDto) throws RealEstateServiceException {
        if (userId == null) {
            throw new IllegalArgumentException("The given user ID must not be null");
        }
        if (realEstateDto == null) {
            throw new IllegalArgumentException("The given real estate must not be null");
        }

        log.debug("Try to create new real estate {} requested by {}.",
            realEstateDto.getTitle(), userId);

        RealEstateEntity realEstateEntity = mapper.dtoToEntity(realEstateDto);
        realEstateEntity.setCreatedByUserId(userId);

        try {
            RealEstateEntity realEstateRecord = repository.save(realEstateEntity);

            log.debug("Book {} saved to database. Created timestamp {}",
                realEstateRecord.getId(), realEstateRecord.getDateCreated());

            return realEstateRecord.getId();

        } catch (Exception ex) {
            throw new RealEstateServiceException("Failed to save the real estate", ex);
        }
    }

    /**
     * Fetches all real estates of the specified user.
     *
     * @return a list of real estates.
     * @throws RealEstateServiceException
     */
    public List<RealEstate> getAllRealEstatesByUserId(UUID userId) throws RealEstateServiceException {
        return null;
    }

    /**
     * Fetches a real estate by ID.
     *
     * @param userId user ID (must not null)
     * @param realEstateId real estate ID (must not null)
     * @return a real estate if exists or null
     * @throws RealEstateServiceException
     */
    public RealEstate getRealEstate(UUID userId, UUID realEstateId) throws RealEstateServiceException {
        return null;
    }
}

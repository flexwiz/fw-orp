package fr.ntdt.ezloc.immo.service.mapper;

import fr.ntdt.ezloc.immo.service.RealEstateService;
import fr.ntdt.ezloc.immo.service.dto.RealEstateDto;
import fr.ntdt.ezloc.immo.spi.data.entity.RealEstate;


//import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
//@Slf4j
public class RealEstateMapper {

    private static final org.slf4j.Logger log 
    	= org.slf4j.LoggerFactory.getLogger(RealEstateMapper.class);

    private final ModelMapper mapper;

    /**
     * Create new instance of RealEstateMapper
     * 
     * @param mapper
     * @return RealEstateMapper instance
     */
    public RealEstateMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Convert a real estate DTO (RealEstateDto) to new  real estate entity instance (RealEstate)
     * 
     * @param dto Instance of RealEstateDto
     * @return RealEstate instance
     */
    public RealEstate dtoToEntity(RealEstateDto dto) {
        log.debug("Convert 'RealEstateDto' instance to new real estate entity. ['title' {}]", dto.getTitle());

        RealEstate entity = mapper.map(dto, RealEstate.class);
        entity.setId(UUID.randomUUID());

        log.debug("Real estate entity {} with id {} initialized.", entity.getTitle(), entity.getId());
        return entity;
    }

    /**
     * Convert a real estate entity to new DTO instance
     * 
     * @param entity A real estate
     * @return A real estate DTO instance
     */
    public RealEstateDto entityToDto(RealEstate entity) {
        log.debug("Convert 'RealEstate' entity to DTO. ['id': {}, 'title', {}]", entity.getId(), entity.getTitle());

        RealEstateDto dto = mapper.map(entity, RealEstateDto.class);

        log.debug("DTO '{}' initialized.", dto.getTitle());
        return dto;
    }
}
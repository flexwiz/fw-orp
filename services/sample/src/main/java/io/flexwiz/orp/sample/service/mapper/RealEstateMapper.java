package io.flexwiz.orp.sample.service.mapper;

import io.flexwiz.orp.sample.service.dto.RealEstate;
import io.flexwiz.orp.sample.spi.data.entity.RealEstateEntity;


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
     * Convert a real estate DTO @{RealEstate} to new real estate entity @{RealEstateEntity} instance
     *
     * @param dto a real estate @{RealEstate} instance to convert
     * @return RealEstate instance
     */
    public RealEstateEntity dtoToEntity(RealEstate dto) {
        log.debug("Convert 'RealEstate' DTO instance to new real estate entity. ['title' {}]", dto.getTitle());

        RealEstateEntity entity = mapper.map(dto, RealEstateEntity.class);
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
    public RealEstate entityToDto(RealEstateEntity entity) {
        log.debug("Convert 'RealEstate' entity to DTO. ['id': {}, 'title', {}]", entity.getId(), entity.getTitle());

        RealEstate dto = mapper.map(entity, RealEstate.class);

        log.debug("DTO '{}' initialized.", dto.getTitle());
        return dto;
    }
}

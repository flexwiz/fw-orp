package io.flexwiz.orp.dto;

import io.flexwiz.orp.spi.data.RealEstate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RealEstateMapper {
    RealEstate fromDTO(RealEstateDto dto);
    RealEstateDto fromEntity(RealEstate entity);
}

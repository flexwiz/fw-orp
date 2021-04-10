package fr.ntdt.ezloc.dto;

import fr.ntdt.ezloc.spi.data.RealEstate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RealEstateMapper {
    RealEstate fromDTO(RealEstateDto dto);
    RealEstateDto fromEntity(RealEstate entity);
}

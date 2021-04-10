package fr.ntdt.ezloc.api;

import fr.ntdt.ezloc.dto.CreateRealEstateRequest;
import fr.ntdt.ezloc.dto.RealEstateDto;
import fr.ntdt.ezloc.spi.data.RealEstate;

import javax.validation.Valid;
import java.util.List;

public interface ApiResource {

    List<RealEstate> getAll();

    List<RealEstateDto> byUser(Long userId);

    RealEstateDto byId(Long id, Long userId);

    Long create(@Valid CreateRealEstateRequest request);
}

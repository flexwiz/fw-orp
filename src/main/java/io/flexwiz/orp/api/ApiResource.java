package io.flexwiz.orp.api;

import io.flexwiz.orp.dto.CreateRealEstateRequest;
import io.flexwiz.orp.dto.RealEstateDto;
import io.flexwiz.orp.spi.data.RealEstate;

import javax.validation.Valid;
import java.util.List;

public interface ApiResource {

    List<RealEstate> getAll();

    List<RealEstateDto> byUser(Long userId);

    RealEstateDto byId(Long id, Long userId);

    Long create(@Valid CreateRealEstateRequest request);
}

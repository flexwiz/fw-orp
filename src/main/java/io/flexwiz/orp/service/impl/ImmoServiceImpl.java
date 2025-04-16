package io.flexwiz.orp.service.impl;

import io.flexwiz.orp.dto.CreateRealEstateRequest;
import io.flexwiz.orp.dto.RealEstateDto;
import io.flexwiz.orp.dto.RealEstateMapper;
import io.flexwiz.orp.service.OrpService;
import io.flexwiz.orp.spi.data.RealEstate;
import io.flexwiz.orp.spi.data.RealEstateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrpServiceImpl implements OrpService {

    @Inject
    RealEstateMapper realEstateMapper;

    @Inject
    RealEstateRepository realEstateRepository;

    @Override
    public Long create(CreateRealEstateRequest request) {
        RealEstate realEstate = this.realEstateMapper.fromDTO(request.getRealEstate());
        realEstate.ownerId = request.getUserId();
        realEstateRepository.persist(realEstate);
        return realEstate.id;
    }

    @Override
    public List<RealEstateDto> allByUser(Long userId) {
        return realEstateRepository.byUserId(userId)
                .stream()
                .map(realEstateMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RealEstateDto byId(Long id, Long userId) {
        return realEstateRepository.byIdAndUserId(id, userId)
                .map(realEstateMapper::fromEntity)
                .orElse(null);
    }
}

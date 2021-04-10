package fr.ntdt.ezloc.service.impl;

import fr.ntdt.ezloc.dto.CreateRealEstateRequest;
import fr.ntdt.ezloc.dto.RealEstateDto;
import fr.ntdt.ezloc.dto.RealEstateMapper;
import fr.ntdt.ezloc.service.ImmoService;
import fr.ntdt.ezloc.spi.data.RealEstate;
import fr.ntdt.ezloc.spi.data.RealEstateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ImmoServiceImpl implements ImmoService {

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

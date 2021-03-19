package fr.ntdt.ezloc.immo.spi.data;

import fr.ntdt.ezloc.immo.spi.data.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface IRealEstateRepository extends JpaRepository<RealEstate, UUID> {

    //RealEstate save(RealEstate entity);

    Set<RealEstate> findRealEstatesByCreatedByUserId(UUID id);

    RealEstate findRealEstateById(UUID id);

    // add custom queries here
}
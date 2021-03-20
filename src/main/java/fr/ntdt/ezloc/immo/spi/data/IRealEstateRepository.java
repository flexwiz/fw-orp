package fr.ntdt.ezloc.immo.spi.data;

import fr.ntdt.ezloc.immo.spi.data.entity.RealEstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface IRealEstateRepository extends JpaRepository<RealEstateEntity, UUID> {

    //RealEstate save(RealEstate entity);

    Set<RealEstateEntity> findRealEstatesByCreatedByUserId(UUID id);

    RealEstateEntity findRealEstateById(UUID id);

    // add custom queries here
}
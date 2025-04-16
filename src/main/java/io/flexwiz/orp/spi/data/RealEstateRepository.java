package io.flexwiz.orp.spi.data;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RealEstateRepository implements PanacheRepository<RealEstate> {

    public List<RealEstate> byUserId(Long userId){
        return find("ownerId", userId).list();
    }

    public Optional<RealEstate> byIdAndUserId(Long id, Long userId) {
        return find("id = ?1 and ownerId = ?2", id, userId).firstResultOptional();
    }
}

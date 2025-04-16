package io.flexwiz.orp.api.graphql;


import io.flexwiz.orp.api.ApiResource;
import io.flexwiz.orp.dto.CreateRealEstateRequest;
import io.flexwiz.orp.dto.RealEstateDto;
import io.flexwiz.orp.service.OrpService;
import io.flexwiz.orp.spi.data.RealEstate;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@GraphQLApi
public class OrpGraphQl implements ApiResource {

    @Inject
    OrpService orpService;

    @Query("GetAll")
    @Description("Get all registered realestates")
    @Override
    public List<RealEstate> getAll() { return RealEstate.listAll(); }

    @Query("ByUser")
    @Description("Get all realEstates for a specified user")
    @Override
    public List<RealEstateDto> byUser(@Name("userId") Long userId) {
        return orpService.allByUser(userId);
    }

    @Query("ById")
    @Description("Get a realEstate by its id")
    @Override
    public RealEstateDto byId(@Name("realEstateId") Long id, @Name("userId")Long userId) {
        return orpService.byId(id, userId);
    }

    /**
     * Add an expanding attributes called <i>others</i> to Response of type <i>RealEstateDto</i>
     *
     */
    public List<String> others(@Source RealEstateDto dto) {
        return List.of("test1", "test2");
    }

    @Mutation("Create")
    @Description("Create a realEstate")
    @Transactional
    @Override
    public Long create(CreateRealEstateRequest request) {
        return orpService.create(request);
    }

}

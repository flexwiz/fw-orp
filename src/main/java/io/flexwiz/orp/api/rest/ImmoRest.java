package io.flexwiz.orp.api.rest;

import io.flexwiz.orp.api.ApiResource;
import io.flexwiz.orp.spi.data.RealEstate;
import io.flexwiz.orp.dto.CreateRealEstateRequest;
import io.flexwiz.orp.dto.RealEstateDto;
import io.flexwiz.orp.service.OrpService;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/real-states")
@Produces(MediaType.APPLICATION_JSON)
public class OrpRest implements ApiResource {

    @Inject
    OrpService orpService;

    @GET
    public List<RealEstate> getAll() { return RealEstate.listAll(); }

    @GET
    @Path("/user/{userId}")
    public List<RealEstateDto> byUser(@PathParam("userId") Long userId) {
        return orpService.allByUser(userId);
    }

    @GET
    @Path("/{id}")
    public RealEstateDto byId(@PathParam("id") Long id, @HeaderParam("userId") Long userId){
        return orpService.byId(id, userId);
    }

    @POST
    @Transactional
    public Long create(@Valid CreateRealEstateRequest request){
        return orpService.create(request);
    }

    @GET
    @Path("/hello")
    public String helle() {
        return "Hello";
    }
}

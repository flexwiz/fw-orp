package fr.ntdt.ezloc.api.rest;

import fr.ntdt.ezloc.api.ApiResource;
import fr.ntdt.ezloc.spi.data.RealEstate;
import fr.ntdt.ezloc.dto.CreateRealEstateRequest;
import fr.ntdt.ezloc.dto.RealEstateDto;
import fr.ntdt.ezloc.service.ImmoService;
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
public class ImmoRest implements ApiResource {

    @Inject
    ImmoService immoService;

    @GET
    public List<RealEstate> getAll() { return RealEstate.listAll(); }

    @GET
    @Path("/user/{userId}")
    public List<RealEstateDto> byUser(@PathParam("userId") Long userId) {
        return immoService.allByUser(userId);
    }

    @GET
    @Path("/{id}")
    public RealEstateDto byId(@PathParam("id") Long id, @HeaderParam("userId") Long userId){
        return immoService.byId(id, userId);
    }

    @POST
    @Transactional
    public Long create(@Valid CreateRealEstateRequest request){
        return immoService.create(request);
    }

    @GET
    @Path("/hello")
    public String helle() {
        return "Hello";
    }
}

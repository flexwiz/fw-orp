package fr.ntdt.ezloc;

import fr.ntdt.ezloc.spi.data.RealEstate;
import fr.ntdt.ezloc.dto.CreateRealEstateRequest;
import fr.ntdt.ezloc.dto.RealEstateDto;
import fr.ntdt.ezloc.service.ImmoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/real-states")
@Produces(MediaType.APPLICATION_JSON)
public class ImmoResource {

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
    public Response create(@Valid CreateRealEstateRequest request){
        Long id = immoService.create(request);
        return Response.status(Response.Status.CREATED).entity(id).build();
    }

    @GET
    @Path("/hello")
    public String helle() {
        return "Hello";
    }
}

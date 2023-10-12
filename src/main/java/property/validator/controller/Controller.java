package property.validator.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import property.validator.dto.PropertyDTO;
import property.validator.response.APIResponse;
import property.validator.service.HttpService;

@Path("/validate")
public class Controller {
    
    @Inject
    HttpService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validate(PropertyDTO dto) {
        try {
            service.response(dto.getId());
            return Response.status(202).entity(new APIResponse(202, "ACCEPTED")).build();
        } catch (Exception e) {
            return Response.status(400).entity(new APIResponse(400, e.getMessage())).build();
        }
    }

}

package property.validator.application.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import property.validator.application.dto.PropertyDTO;
import property.validator.application.response.APIResponse;
import property.validator.domain.Schedule;
import property.validator.infrastructure.repository.ScheduleRepository;

@Path("/validate")
public class Controller {

    @Inject
    ScheduleRepository repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validate(PropertyDTO dto) {
        try {
            Schedule schedule = new Schedule(dto.getId(), dto.getUserCPF(), dto.getPropertyRegistry());
            repository.save(schedule);
            return Response.status(202).entity(new APIResponse(202, "ACCEPTED")).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(400).entity(new APIResponse(400, e.getMessage())).build();
        }
    }
}

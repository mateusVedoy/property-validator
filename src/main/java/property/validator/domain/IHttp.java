package property.validator.domain;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient()
public interface IHttp {
    @POST
    @Path("/7406f4b7-7a33-44e0-9864-708d9a79f3c4/{propertyId}/{isValid}")
    @Produces(MediaType.APPLICATION_JSON)
    void post(@PathParam("propertyId") Long propertyId, @PathParam("isValid") String isValid);
}

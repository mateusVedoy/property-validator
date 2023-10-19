package property.validator.infrastructure.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import property.validator.application.useCase.SetRandomResponse;
import property.validator.domain.IHttp;

@ApplicationScoped
public class HttpService {

    @Inject
    SetRandomResponse validator;
    @Inject
    @RestClient
    IHttp http;

    private Long id = 1L;

    public void response(Long propId) {
        this.id = propId;
        schedule();
    }

    // @Scheduled(cron = "*/1 * * * *")
    public void schedule() {
        String resp = validator.set();
        http.post(id, resp);
    }
}

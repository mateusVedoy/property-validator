package property.validator.application.useCase;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import property.validator.domain.IHttp;
import property.validator.domain.Schedule;
import property.validator.infrastructure.repository.ScheduleRepository;

@ApplicationScoped
public class NotifyRecipient {
    @Inject
    SetRandomResponse validator;
    @Inject
    @RestClient
    IHttp http;
    @Inject
    ScheduleRepository repository;

   @Scheduled(every = "2m")
    public void schedule() {
        String response = validator.set();
        Schedule schedule = repository.getAllPending();
        if(schedule != null)
            http.post(schedule.getPropertyId(), response);
    }
}

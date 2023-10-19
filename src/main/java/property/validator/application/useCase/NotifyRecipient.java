package property.validator.application.useCase;

import java.util.List;

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
    @RestClient
    IHttp http;
    @Inject
    ScheduleRepository repository;

   @Scheduled(every = "2m")
    public void schedule() {
        List<Schedule> schedules = repository.getAllPending();
        schedules.forEach(schedule -> {
            http.post(schedule.getPropertyId(), schedule.getIsValid());
        });            
    }
}

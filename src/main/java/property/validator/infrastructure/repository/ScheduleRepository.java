package property.validator.infrastructure.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import property.validator.domain.Schedule;

@ApplicationScoped
public class ScheduleRepository {
    
    private List<Schedule> schedules = new ArrayList<>();

    public Schedule findByPropertyId(Long id) {
        return schedules.stream()
        .filter(schedule -> schedule.getPropertyId() == id)
        .findAny()
        .orElse(null);
    }

    public List<Schedule> getAllPending() {
        return schedules.stream()
        .filter(schedule -> schedule.getMoment().isBefore(getMoment()))
        .collect(Collectors.toList());
    }

    private LocalDateTime getMoment() {
        LocalDateTime dt = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(dt);
        return dt;
    }

    public void save(Schedule schedule) {
        System.out.println("Previous queue size: " + schedules.size());
        schedules.add(schedule);
        System.out.println("Current queue size: " + schedules.size());
    }

    public void removeByPropertyId(Long id) {
        Schedule schedule = this.findByPropertyId(id);
        if(schedule != null)
            schedules.remove(schedule);
    }
}

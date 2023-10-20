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
        String moment = getMoment();

        return schedules.stream()
        .filter(schedule -> schedule.getMoment().equals(moment))
        .collect(Collectors.toList());
    }

    private String getMoment() {
        LocalDateTime initialTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedTime = initialTime.format(formatter);
        return formattedTime;
    }

    public void save(Schedule schedule) {
        System.out.println("Previous size: " + schedules.size());
        schedules.add(schedule);
        System.out.println("Current size: " + schedules.size());
    }

    public void removeByPropertyId(Long id) {
        Schedule schedule = this.findByPropertyId(id);
        if(schedule != null)
            schedules.remove(schedule);
    }
}

package property.validator.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.Getter;

@Getter
public class Schedule {
    private Long propertyId;
    private Long userCPF;
    private Long propertyRegistry;
    private String moment;

    public Schedule(
            Long propertyId,
            Long userCPF,
            Long propertyRegistry) {
        this.propertyId = propertyId;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
        this.moment = this.setDaTime();
    }

    private String setDaTime() {
        LocalDateTime initialTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMinutes(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedTime = initialTime.format(formatter);
        return formattedTime;
    }
}

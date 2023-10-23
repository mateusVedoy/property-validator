package property.validator.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import lombok.Getter;
import property.validator.application.response.State;

@Getter
public class Schedule {
    private Long propertyId;
    private Long userCPF;
    private Long propertyRegistry;
    private String moment;
    private String isValid;

    public Schedule(
            Long propertyId,
            Long userCPF,
            Long propertyRegistry) {
        this.propertyId = propertyId;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
        this.moment = this.setDaTime();
        this.isValid = setValid();
        System.out.println("New Schedule has been created");
    }

    private String setDaTime() {
        LocalDateTime initialTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMinutes(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedTime = initialTime.format(formatter);
        return formattedTime;
    }

    private String setValid() {
        Random rand = new Random();
        int value = rand.nextInt(2);
        return value == 1 ? State.OK.getValue() : State.NOK.getValue();
    }
}

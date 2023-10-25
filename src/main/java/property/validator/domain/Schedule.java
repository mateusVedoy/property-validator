package property.validator.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import lombok.Getter;
import property.validator.application.response.State;

@Getter
public class Schedule {
    private Long propertyId;
    private String userCPF;
    private String propertyRegistry;
    private LocalDateTime moment;
    private String isValid;

    public Schedule(
            Long propertyId,
            String userCPF,
            String propertyRegistry) {
        this.propertyId = propertyId;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
        this.moment = this.setDaTime();
        this.isValid = setValid();
        System.out.println("New Schedule has been created to "+this.moment);
    }

    private LocalDateTime setDaTime() {
        return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMinutes(2);
    }

    private String setValid() {
        Random rand = new Random();
        int value = rand.nextInt(2);
        return value == 1 ? State.OK.getValue() : State.NOK.getValue();
    }
}

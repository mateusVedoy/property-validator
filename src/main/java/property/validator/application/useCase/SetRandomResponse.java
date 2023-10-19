package property.validator.application.useCase;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;
import property.validator.application.response.State;

@ApplicationScoped
public class SetRandomResponse {
    
    public String set() {
        Random rand = new Random();
        int value = rand.nextInt(2);
        return value == 1 ? State.OK.getValue() : State.NOK.getValue();
    }
}

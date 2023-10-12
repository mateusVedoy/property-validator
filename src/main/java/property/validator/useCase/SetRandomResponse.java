package property.validator.useCase;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;
import property.validator.response.State;

@ApplicationScoped
public class SetRandomResponse {
    
    public String set() {
        Random rand = new Random();
        int value = rand.nextInt(2);
        return value == 1 ? State.OK.getValue() : State.NOK.getValue();
    }
}

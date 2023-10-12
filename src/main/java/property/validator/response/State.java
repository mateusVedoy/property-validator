package property.validator.response;

import lombok.Getter;

@Getter
public enum State {

    OK("OK"),
    NOK("NOK");

    public String value;

    State(String value) {
        this.value = value;
    }
}

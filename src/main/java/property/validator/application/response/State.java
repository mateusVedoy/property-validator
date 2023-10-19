package property.validator.application.response;

public enum State {

    OK("OK"),
    NOK("NOK");

    public String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

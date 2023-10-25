package property.validator.application.dto;

public class PropertyDTO {
    private Long id;
    private String userCPF;
    private String propertyRegistry;

    public PropertyDTO(Long id, String userCPF, String propertyRegistry) {
        this.id = id;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
    }

    public Long getId() {
        return this.id;
    }

    public String getUserCPF() {
        return this.userCPF;
    }

    public String getPropertyRegistry() {
        return this.propertyRegistry;
    }
}

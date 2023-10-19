package property.validator.application.dto;

public class PropertyDTO {
    private Long id;
    private Long userCPF;
    private Long propertyRegistry;

    public PropertyDTO(Long id, Long userCPF, Long propertyRegistry) {
        this.id = id;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
    }

    public Long getId() {
        return this.id;
    }

    public Long getUserCPF() {
        return this.userCPF;
    }

    public Long getPropertyRegistry() {
        return this.propertyRegistry;
    }
}

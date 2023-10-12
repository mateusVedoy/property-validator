package property.validator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    private Long userCPF;
    private Long propertyRegistry;

    public PropertyDTO(Long id, Long userCPF, Long propertyRegistry) {
        this.id = id;
        this.userCPF = userCPF;
        this.propertyRegistry = propertyRegistry;
    }
}

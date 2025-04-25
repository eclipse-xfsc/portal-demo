package eu.gaia_x.demo.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActivateRq {
    @JsonProperty(value = "id", required = true)
    private String id;
    @JsonProperty(value = "is_activated", required = true)
    private boolean isActivated;
}

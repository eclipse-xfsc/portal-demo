package eu.gaia_x.demo.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Participant implements PartItem {
    @JsonProperty(value = "id", required = true)
    private String id;
    @JsonProperty(value = "participant_name", required = true)
    private String participantName;
    @JsonProperty(value = "location", required = true)
    private String location;
    @JsonProperty(value = "registration_type")
    private String registrationType;

    @Override
    public String getType() {
        return registrationType;
    }
}

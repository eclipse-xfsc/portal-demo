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
public class PartRequest implements PartItem {
    @JsonProperty(value = "id", required = true)
    private String id;
    @JsonProperty(value = "participant_name", required = true)
    private String participantName;
    @JsonProperty(value = "location", required = true)
    private String location;
    @JsonProperty(value = "request_type")
    private String requestType;

    @Override
    public String getType() {
        return requestType;
    }
}

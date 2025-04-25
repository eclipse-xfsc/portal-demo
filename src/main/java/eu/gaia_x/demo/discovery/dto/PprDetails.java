package eu.gaia_x.demo.discovery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@AllArgsConstructor
public class PprDetails {
    private String description;
    private String[] certificates;
    private String location;
    @JsonProperty("location_flag")
    private String locationFlag;
    @JsonProperty("member_since")
    private String memberSince;
    @JsonProperty("last_updated")
    private String lastUpdated;
}

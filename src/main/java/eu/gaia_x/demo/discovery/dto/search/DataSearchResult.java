package eu.gaia_x.demo.discovery.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class DataSearchResult implements SearchResult {
    private String type;
    private String logo;
    @JsonProperty("ppr_url")
    private String pprUrl;
    private String name;
    @JsonProperty("ppr_name")
    private String pprName;
    private String id;
    @JsonProperty("short_description")
    private String shortDescription;
    private String location;
}

package eu.gaia_x.demo.discovery.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class PprSearchResult implements SearchResult {
    private String type;
    private String logo;
    @JsonProperty("ppr_url")
    private String pprUrl;
    private String name;
    private String id;
    private String sustainability;
    private String availability;
    private String location;
}

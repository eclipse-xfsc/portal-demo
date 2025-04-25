package eu.gaia_x.demo.discovery.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class ServiceSearchResult implements SearchResult {
    private String type;
    private String logo;
    private String name;
    private String id;
    @JsonProperty("ppr_name")
    private String pprName;
    @JsonProperty("ppr_url")
    private String pprUrl;
    private String stack;
    private String security;
    private String location;
    private String img_preview_url;
    private String description;
}

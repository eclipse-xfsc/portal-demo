package eu.gaia_x.demo.discovery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class DependendServiceDetails {
    private String id;
    private String name;
    @JsonProperty("img_preview_url")
    private String imgPreviewUrl;
    private String logo;
    @JsonProperty("ppr_name")
    private String pprName;
    @JsonProperty("ppr_url")
    private String pprUrl;
    private String description;
    private String features;
    private String stack;
    private String security;
    private String location;
    @JsonProperty("location_flag")
    private String locationFlag;
    @JsonProperty("last_updated")
    private String lastUpdated;
    private String category;
    private List<String> tags;
    @JsonProperty("terms_of_use")
    private String termsUse;
    @JsonProperty("slot_id")
    private Integer slotId;
    private Boolean included;
}

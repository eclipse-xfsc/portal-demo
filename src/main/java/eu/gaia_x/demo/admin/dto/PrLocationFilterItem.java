package eu.gaia_x.demo.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrLocationFilterItem {
    @JsonProperty(value = "loc_code", required = true)
    private String locCode;
    @JsonProperty(value = "name", required = true)
    private String itemName;
    @JsonProperty(value = "qty", required = true)
    private int count;

}

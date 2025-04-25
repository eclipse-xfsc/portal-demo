package eu.gaia_x.demo.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationFilterDto {
    @JsonProperty(value = "items", required = true)
    private List<PrLocationFilterItem> items;
}

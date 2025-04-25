package eu.gaia_x.demo.sp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SaveRequest {
    private String name;
    @JsonProperty(value = "service_id", required = true)
    private String serviceId;
    private String action;

    @JsonProperty(value = "selected_items", required = true)
    private List<SelectedItems> selectedItems;
}

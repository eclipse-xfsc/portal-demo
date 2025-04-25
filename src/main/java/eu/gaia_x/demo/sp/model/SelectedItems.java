package eu.gaia_x.demo.sp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectedItems {
    @JsonProperty(value = "slot_id", required = true)
    private String slotId;
    @JsonProperty(value = "service_id", required = true)
    private String serviceId;
}

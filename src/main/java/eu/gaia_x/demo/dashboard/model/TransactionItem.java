package eu.gaia_x.demo.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionItem {
    @JsonProperty(value = "id", required = true)
    private String id;
    @JsonProperty(value = "title", required = true)
    private String title;
    @JsonProperty(value = "subtitle", required = true)
    private String subtitle;
    @JsonProperty(value = "date", required = true)
    private String date;
}

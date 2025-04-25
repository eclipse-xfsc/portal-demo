package eu.gaia_x.demo.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NewsItem {
    @JsonProperty(value = "id", required = true)
    private String id;
    @JsonProperty(value = "title", required = true)
    private String title;
    @JsonProperty(value = "subtitle", required = true)
    private String subtitle;
    @JsonProperty(value = "date", required = true)
    private String date;
}

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
public class FilterResult {
    @JsonProperty("data")
    private List<? extends PartItem> items;
    @JsonProperty("page_count")
    private int pageCount;
    @JsonProperty("prev")
    private String prev;
    @JsonProperty("next")
    private String next;
}

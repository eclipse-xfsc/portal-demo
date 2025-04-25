package eu.gaia_x.demo.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterItem {
    @JsonProperty(value = "name", required = true)
    private String itemName;
    @JsonProperty(value = "qty", required = true)
    private int count;

    public static List<FilterItem> createFilterItems(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .map(e -> new FilterItem(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}

package eu.gaia_x.demo.discovery.rand;

import eu.gaia_x.demo.discovery.dto.search.SearchResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class SearchParameters {
    private int pageNum;
    private List<String> location;
    private SearchResultEnum sr;
    private int size;
}

package eu.gaia_x.demo.discovery.rand;

import eu.gaia_x.demo.discovery.dto.search.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FilteredDataResult {
    private int pageCount;
    private List<? extends SearchResult> filteredData;
}

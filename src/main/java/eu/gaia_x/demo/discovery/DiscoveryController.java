package eu.gaia_x.demo.discovery;

import eu.gaia_x.demo.discovery.dto.*;
import eu.gaia_x.demo.discovery.dto.chips.ChipsEntry;
import eu.gaia_x.demo.discovery.dto.search.SearchResultEnum;
import eu.gaia_x.demo.discovery.rand.DiscoveryRandomizer;
import eu.gaia_x.demo.discovery.rand.FilteredDataResult;
import eu.gaia_x.demo.discovery.rand.SearchParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@Log4j2
@RestController
@RequestMapping(value = {"/demo/api/discovery"})
public class DiscoveryController {

  @Autowired
  private DiscoveryRandomizer randomizer;

  @GetMapping(value = {"/services/{id}/contacts", "/data/{id}/contacts", "/ppr/{id}/contacts"})
  @ResponseBody
  public List<ContactInfo> getContactsForService(
          @PathVariable final String id
  ) {
    return List.of(
            ContactInfo.of(ContactType.TECH_PHONE, "+49 00 0000 11111"),
            ContactInfo.of(ContactType.TECH_EMAIL, String.format("%s@%s", id, "example.com")),
            ContactInfo.of(ContactType.SUPP_PHONE, "+49 00 0000 22222"),
            ContactInfo.of(ContactType.SUPP_EMAIL, String.format("%s@%s", id, "example.com"))
    );
  }

  @GetMapping(value = {"/services/{id}/screenshots"})
  @ResponseBody
  public List<ScreenshotInfo> getScreenshotsForService(@PathVariable final String id) {
    return randomizer.generateScreenshotInfo(id);
  }

  @GetMapping(value = {"/services/{id}/price", "/data/{id}/price"})
  @ResponseBody
  public List<PriceInfo> getDataPriceForService(@PathVariable final String id) {
    return randomizer.generatePriceInfo();
  }

  @GetMapping(value = {"/ppr/{pprId}/details"})
  @ResponseBody
  public PprDetails getPprDetails(@PathVariable final String pprId) {
    return randomizer.generatePprDetails().get(0);
  }

  @GetMapping(value = {"/data/{dataId}/sample-records"})
  @ResponseBody
  public List<SampleRecord> getSampleRecords(@PathVariable final String dataId, final HttpServletRequest request) {
    return randomizer.generateSampleRecord();
  }

  @GetMapping(value = {"/data/{dataId}/details"})
  @ResponseBody
  public DataDetails getDataDetails(@PathVariable final String dataId, final HttpServletRequest request) {
    return randomizer.generateDataDetails().get(0);
  }

  @GetMapping(value = {"/ppr/{pprId}/data"})
  @ResponseBody
  public List<DataDetails> getPprDataDetails(@PathVariable final String pprId, final HttpServletRequest request) throws MalformedURLException {
    return randomizer.generateDataDetails();
  }

  @GetMapping(value = {"/services/{id}/details"})
  @ResponseBody
  public ServiceDetails getServiceDetails(@PathVariable final String id, final HttpServletRequest request) {
    return randomizer.generateServiceDetailsForService(id);
  }

  @GetMapping(value = {"/ppr/{id}/services"})
  @ResponseBody
  public List<ServiceDetails> getPprServices(@PathVariable final String id, final HttpServletRequest request) {
    return randomizer.generateServiceDetailsForPPR(id);
  }

  @GetMapping(value = {"/data/filter-criterias"})
  @ResponseBody
  public FilterDto dataFilter(final HttpServletRequest request) throws FileNotFoundException {
    return randomizer.prepareFilterDto(SearchResultEnum.DATA);
  }

  @GetMapping(value = {"/data/suggestions", "/ppr/suggestions", "/services/suggestions"})
  @ResponseBody
  public List<ChipsEntry> chipsSuggestions(
          final HttpServletRequest request,
          @RequestParam("searchTerm") String searchTerm
  ) {
    if (searchTerm.contains("NODE=")
            || searchTerm.contains("PROVIDER=")
            || searchTerm.contains("STORAGE=")
            || searchTerm.contains("SERVICE=")
            || searchTerm.contains("COMPUTE=")
    ) {
      // At least 1st level
      if (searchTerm.contains("LOCATION=")
              || searchTerm.contains("AREA=")) {
        // At least 2nd level
        if (searchTerm.contains("LOCATION=")) {
          // Smth for location
          if (searchTerm.contains("COUNTRY=") || searchTerm.contains("REGION=")) {
            return Collections.emptyList();
          } else {
            return
                    Arrays.asList(
                            new ChipsEntry("COUNTRY", "COUNTRY="),
                            new ChipsEntry("REGION", "REGION=")
                    );
          }
        } else if (searchTerm.contains("AREA=")) {
          // Smth for AREA
          if (searchTerm.contains("IT=") || searchTerm.contains("MANUFACTURING=")) {
            return Collections.emptyList();
          } else {
            return
                    Arrays.asList(
                            new ChipsEntry("IT", "IT="),
                            new ChipsEntry("MANUFACTURING", "MANUFACTURING=")
                    );
          }
        }
      } else {
        // Default 2nd level of chips
        return
                Arrays.asList(
                        new ChipsEntry("LOCATION", "LOCATION="),
                        new ChipsEntry("AREA", "AREA=")
                );
      }
    }

    // by default return 1st level
    return
            Arrays.asList(
                    new ChipsEntry("NODE", "NODE="),
                    new ChipsEntry("PROVIDER", "PROVIDER="),
                    new ChipsEntry("STORAGE", "STORAGE="),
                    new ChipsEntry("SERVICE", "SERVICE="),
                    new ChipsEntry("COMPUTE", "COMPUTE=")
            );
  }

  @GetMapping(value = {"/services/filter-criterias"})
  @ResponseBody
  public FilterDto servicesFilter(final HttpServletRequest request) throws FileNotFoundException {
    return randomizer.prepareFilterDto(SearchResultEnum.SERVICE);
  }

  @GetMapping(value = {"/services/{serviceId}/{slotId}/filter-criterias"})
  @ResponseBody
  public FilterDto servicesFilterWithinServiceAndSlot(
          final HttpServletRequest request,
          @PathVariable final String serviceId,
          @PathVariable final String slotId
  ) throws FileNotFoundException {
    return randomizer.prepareFilterDto(
            SearchResultEnum.SERVICE,
            randomizer.getListBySearchParamServiceSlot(serviceId, slotId));
  }

//  getListBySearchParamServiceSlot(serviceId, slotId);

  @GetMapping(value = {"/ppr/filter-criterias"})
  @ResponseBody
  public FilterDto pprFilter(final HttpServletRequest request) throws FileNotFoundException {
    return randomizer.prepareFilterDto(SearchResultEnum.PPR);
  }

  @GetMapping(value = {"/data/search"})
  @ResponseBody
  public Map<String, Object> dataSearch(
          final HttpServletRequest request,
          @RequestParam MultiValueMap<String, String> params
  ) {
    return prepareSearchResult(params,
            SearchResultEnum.DATA,
            "/discovery/data/search?page=%s&%s",
            x -> randomizer.getDataSearchResults(x),
            request.getQueryString());
  }

  @GetMapping(value = {"/ppr/search"})
  @ResponseBody
  public Map<String, Object> pprSearch(
          final HttpServletRequest request,
          @RequestParam MultiValueMap<String, String> params
  ) {
    return prepareSearchResult(params,
            SearchResultEnum.PPR,
            "/discovery/ppr/search?page=%s&%s",
            x -> randomizer.getDataSearchResults(x),
            request.getQueryString());
  }

  @GetMapping(value = {"/services/search"})
  @ResponseBody
  public Map<String, Object> srvSearch(
          final HttpServletRequest request,
          @RequestParam MultiValueMap<String, String> params
  ) {
    return prepareSearchResult(params,
            SearchResultEnum.SERVICE,
            "/discovery/services/search?page=%s&%s",
            x -> randomizer.getDataSearchResults(x),
            request.getQueryString());
  }

  @GetMapping(value = {"/services/{serviceId}/{slotId}/search"})
  @ResponseBody
  public Map<String, Object> srvSearchWithinService(
          final HttpServletRequest request,
          @PathVariable final String serviceId,
          @PathVariable final String slotId,
          @RequestParam MultiValueMap<String, String> params
  ) {
    final String endpointPrefix = String.format("/discovery/services/%s/%s/search", serviceId, slotId);
    return prepareSearchResult(params,
            SearchResultEnum.SERVICE,
            endpointPrefix + "?page=%s&%s",
            x -> randomizer.getSearchResultsWithinServiceAndSlot(x, serviceId, slotId),
            request.getQueryString());
  }


  //<editor-fold desc="Footer">
  private Map<String, Object> prepareSearchResult(
          MultiValueMap<String, String> params,
          SearchResultEnum sr,
          String endpoint,
          Function<SearchParameters, FilteredDataResult> fun,
          String queryString
  ) {
    List<String> page = params.getOrDefault("page", Collections.singletonList("0"));
    int curPageNum = Integer.parseInt(page.get(0));
    List<String> sizeStr = params.getOrDefault("size", Collections.singletonList("0"));
    int size = Integer.parseInt(sizeStr.get(0));
    List<String> location = params.keySet().stream()
                                  .filter(x -> x.equalsIgnoreCase("location"))
                                  .flatMap(x -> params.getOrDefault(x, Collections.emptyList()).stream())
                                  .collect(Collectors.toList());
    Map<String, Object> result = new HashMap<>();
    SearchParameters sp = new SearchParameters(curPageNum, location, sr, size);
    FilteredDataResult filteredResult = fun.apply(sp);

    int nextPage = curPageNum + 1;
    int prevPage = curPageNum - 1;
    int pageCount = filteredResult.getPageCount();

    if (pageCount > 0) {
      if (curPageNum > pageCount || curPageNum < 0) {
        throw new IndexOutOfBoundsException("Cannot show more than " + pageCount + " pages");
      }
    }

    if (nextPage < pageCount) {
      result.put("next", preparePageLink(queryString, nextPage, endpoint));
    }
    if (prevPage > 0) {
      result.put("prev", preparePageLink(queryString, prevPage, endpoint));
    }
    result.put("pages_count", pageCount);
    result.put("data", filteredResult.getFilteredData());

    return result;
  }

  private String preparePageLink(String queryString, int pageNumber, String endpoint) {
    if (queryString == null) return null;
    log.info("QUERY STRING: " + queryString);
    queryString = queryString.replaceAll("page=\\d+&", "");
    queryString = queryString.replaceAll("&page=\\d+", "");
    queryString = queryString.replaceAll("page=\\d+", "");
    log.info("QUERY STRING: " + queryString);
    String format = String.format(endpoint, pageNumber, queryString)
                          .replaceAll("&&", "&");
    if (format.endsWith("&")) {
      return format.substring(0, format.length() - 1);
    }
    return format;
  }
}

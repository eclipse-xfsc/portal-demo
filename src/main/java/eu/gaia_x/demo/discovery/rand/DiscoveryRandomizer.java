package eu.gaia_x.demo.discovery.rand;

import eu.gaia_x.demo.discovery.dto.*;
import eu.gaia_x.demo.discovery.dto.search.*;
import eu.gaia_x.demo.utils.JsonUtil;
import eu.gaia_x.demo.utils.MockData;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static eu.gaia_x.demo.discovery.rand.AllInfoFromServiceId.lastDigit;

@Component
@Lazy
@Log4j2
public class DiscoveryRandomizer {

  //<editor-fold desc="Header">
  private static final int INIT_PAGE_SIZE = 15;

  private final MockData mocks;
  private final Random random;
  private final List<SearchResult> dataSearchPages;
  private final List<SearchResult> pprSearchPages;
  private final List<SearchResult> serviceSearchPages;
  private final int rEmptyLocation;
  private final int rFullLocation;
  private int pageSize;

  public DiscoveryRandomizer() throws FileNotFoundException {
    mocks = JsonUtil.readJsonFromFile("mocks/discovery-mocks.json", MockData.class);
    random = new Random();
    rEmptyLocation = random.nextInt(mocks.getLocation().size());
    rFullLocation = (rEmptyLocation == 0 || rEmptyLocation == mocks.getLocation().size() - 1) ? 2 : rEmptyLocation + 1;
    dataSearchPages = new ArrayList<>();
    pprSearchPages = new ArrayList<>();
    serviceSearchPages = new ArrayList<>();
    final int initPageCount = random.ints(5, 100).findFirst().orElse(15);
    for (int i = 0; i < INIT_PAGE_SIZE * initPageCount; i++) {
      dataSearchPages.add(createDataSearchResult(i));
      pprSearchPages.add(createPprSearchResult(i));
      serviceSearchPages.add(createServiceSearchResult(generateNextServiceId(i)));
    }
  }
  //</editor-fold>

  //<editor-fold desc="API">
  public FilterDto prepareFilterDto(SearchResultEnum sr) {
    return prepareFilterDto(sr, null);
  }
  public FilterDto prepareFilterDto(SearchResultEnum sr, List<SearchResult> particularData) {
    List<SearchResult> data = particularData == null ? getListBySearchParam(sr) : particularData;
    List<FilterDto.Item> collect = data.stream()
                                       .collect(Collectors.groupingBy(SearchResult::getLocation,
                                               Collectors.counting()))
                                       .entrySet().stream()
                                       .map(entry -> new FilterDto.Item(entry.getKey(), entry.getValue().intValue()))
                                       .collect(Collectors.toList());
    collect.add(new FilterDto.Item(mocks.getLocation().get(rEmptyLocation), 0));
    return new FilterDto()
            .setCategories(Arrays.asList(
                    new FilterDto.Category("Location", collect),
                    mockCategory()
            ))
            .setType(sr.getParamValue());
  }

  public FilteredDataResult getDataSearchResults(SearchParameters sp) {
    pageSize = sp.getSize();
    List<SearchResult> data = getListBySearchParam(sp.getSr());
    if (sp.getLocation().isEmpty()) {
      return getDataSearchResultsByPageNum(sp.getPageNum(), data);
    } else {
      return getDataSearchResultsWithFilter(sp.getPageNum(), sp.getLocation(), data);
    }
  }

  public FilteredDataResult getSearchResultsWithinServiceAndSlot(
          SearchParameters sp, final String serviceId,
          final String slotId
  ) {
    pageSize = sp.getSize();
    List<SearchResult> data = getListBySearchParamServiceSlot(serviceId, slotId);
    if (sp.getLocation().isEmpty()) {
      return getDataSearchResultsByPageNum(sp.getPageNum(), data);
    } else {
      return getDataSearchResultsWithFilter(sp.getPageNum(), sp.getLocation(), data);
    }
  }

  public List<SearchResult> getListBySearchParamServiceSlot(
          final String serviceId,
          final String slotId
  ) {
    final AllInfoFromServiceId info = AllInfoFromServiceId.getAllInfoFromServiceId(serviceId);
    log.info("info: {}", info);
    log.info("search results: {}", info.getDepsIdsPerSlot().get(Integer.valueOf(slotId)));

    final List<SearchResult> res = new ArrayList<>();
    for (final String childId : info.getDepsIdsPerSlot().get(Integer.valueOf(slotId))) {
      res.add(createServiceSearchResult(childId));
    }

    return res;
  }


  public List<ScreenshotInfo> generateScreenshotInfo(String id) {
    int count = random.nextInt(4) + 2;
    ScreenshotInfo.PreviewImg[] imgs = new ScreenshotInfo.PreviewImg[count];
    for (int j = 0; j < count; j++) {
      imgs[j] = new ScreenshotInfo.PreviewImg(getRandomValueFromList(mocks.getPreviewImg(), false));
    }
    return Collections.singletonList(ScreenshotInfo.of(id, imgs));
  }

  public List<PriceInfo> generatePriceInfo() {
    return IntStream.range(0, random.nextInt(4) + 2)
                    .mapToObj(x ->
                            new PriceInfo(
                                    String.valueOf(random.nextInt(100)),
                                    getRandomValueFromList(mocks.getPprName(), false),
                                    String.valueOf((double) Math.round(random.nextDouble() * 10000) / 100)))
                    .collect(Collectors.toList());
  }

  public List<PprDetails> generatePprDetails() {
    List<PprDetails> lst = new ArrayList<>();
    int count = random.nextInt(5) + 2;
    for (int i = 0; i < count; i++) {
      int rand = random.nextInt(mocks.getLocation().size());
      lst.add(new PprDetails(
              getRandomValueFromList(mocks.getDescription(), false),
              new String[]{"Acertifiration", "Bcertification"},
              mocks.getLocation().get(rand),
              mocks.getLocationFlag().get(rand),
              LocalDate.now().minusYears(random.nextInt(4)).minusMonths(random.nextInt(12)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
              LocalDate.now().minusDays(random.nextInt(60)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
      ));
    }
    return lst;
  }

  public List<SampleRecord> generateSampleRecord() {
    List<SampleRecord> lst = new ArrayList<>();
    int count = random.nextInt(5) + 2;
    for (int i = 0; i < count; i++) {
      lst.add(new SampleRecord(
              String.valueOf(random.nextInt(100)),
              getRandomValueFromList(mocks.getDescription(), false),
              getRandomValueFromList(mocks.getCompanyUrl(), false)
      ));
    }
    return lst;
  }

  public List<DataDetails> generateDataDetails() {
    List<DataDetails> lst = new ArrayList<>();
    int count = random.nextInt(5) + 2;
    for (int i = 0; i < count; i++) {
      int r = random.nextInt(mocks.getLocation().size());
      lst.add(new DataDetails(
              String.valueOf(random.nextInt(100)),
              getRandomValueFromList(mocks.getPprName(), false),
              getRandomValueFromList(mocks.getPreviewImg(), false),
              getRandomValueFromList(mocks.getPprName(), false),
              getRandomValueFromList(mocks.getCompanyUrl(), false),
              getRandomValueFromList(mocks.getDescription(), false),
              String.format("Source #%s", random.nextInt(100)),
              getRandomValueFromList(mocks.getCompanyUrl(), false),
              mocks.getLocation().get(r),
              mocks.getLocationFlag().get(r),
              LocalDate.now().minusDays(random.nextInt(60)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
              LocalDate.now().minusDays(random.nextInt(60)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
              mocks.getTags(),
              String.format("Category #%s", random.nextInt(10))
      ));
    }
    return lst;
  }


  private int locationIdxByPPRId(final String pprId) {
    return (mocks.getLocation().size() - 1) % (lastDigit(pprId) + 1);
  }

  private int determineLocationIdxByServiceId(final String serviceId) {
    return locationIdxByPPRId(AllInfoFromServiceId.getAllInfoFromServiceId(serviceId).getPprId());
  }

  public ServiceDetails generateServiceDetailsForService(final String serviceId) {
    log.info("serviceId: {}", serviceId);
    final AllInfoFromServiceId serviceInfo = AllInfoFromServiceId.getAllInfoFromServiceId(serviceId);
    int locationIdx = determineLocationIdxByServiceId(serviceId);

    if (serviceInfo.getServiceType().equals("composite-service")) {
      // composite
      final List<DependendServiceDetails> collect =
              serviceInfo.getDepsIds().stream().map(this::createDependendServiceDetails).collect(Collectors.toList());
//      final List<DependendServiceDetails> collect =
//              IntStream.range(1, serviceInfo.getNbrOfSlots() + 1)
//                       .mapToObj(i -> createDependendServiceDetails(generateChildServiceId(serviceId, i)))
//                       .collect(Collectors.toList());
      return createServiceDetails(serviceId, locationIdx, collect);
    } else if (serviceInfo.getServiceType().equals("service")) {
      // basic
      return createServiceDetails(serviceId, locationIdx, Collections.emptyList());
    } else {
      throw new RuntimeException("Incorrect service type");
    }
  }

  /*
  numberOfServices = lastDigit + 1
  locationIdx =
   */
  public List<ServiceDetails> generateServiceDetailsForPPR(final String pprId) {
    log.info("in generateServiceDetailsForPPR");
    final int lastDigit = pprId.charAt(pprId.length() - 1);
    final int numberOfServices = 1 + lastDigit;
    log.info("numberOfServices: {}", numberOfServices);
    final List<ServiceDetails> lst = new ArrayList<>();
    for (int i = 1; i <= numberOfServices; ++i) {
      final String serviceId = String.format("%s-%d", pprId, i);
      lst.add(generateServiceDetailsForService(serviceId));
    }

//    final List<ServiceDetails> lst = new ArrayList<>();
////    int count = random.nextInt(5) + 2;
//    for (int i = 0; i < lastDigit; i++) {
//      int r = random.nextInt(mocks.getLocation().size());
//      final ServiceDetails sd = createServiceDetails(r);
//      if (i % 2 == 0) {
//        final List<DependendServiceDetails> collect = IntStream.range(1, 3 + (i * 3) % 5)
//                                                               .mapToObj(this::createDependendServiceDetails)
//                                                               .collect(Collectors.toList());
//        sd.setDependentServices(collect);
//      }
//      lst.add(sd);
//    }
    return lst;
  }


  //</editor-fold>

  //<editor-fold desc="Technical Implementations">
  private List<SearchResult> getListBySearchParam(SearchResultEnum sr) {
    switch (sr) {
      case DATA:
        return dataSearchPages;
      case PPR:
        return pprSearchPages;
      case SERVICE:
        return serviceSearchPages;
      default:
        throw new RuntimeException("unknown enum value: " + sr);
    }
  }

  private FilteredDataResult getDataSearchResultsByPageNum(int pageNum, List<SearchResult> data) {
    int start = getPageSize() * pageNum;
    int pageCount = data.size() / getPageSize();
    final int dataSize = data.size();
    final int assumedSize = start + getPageSize();
    return new FilteredDataResult(pageCount, data.subList(start, dataSize < assumedSize ? dataSize : assumedSize));
  }

  private FilteredDataResult getDataSearchResultsWithFilter(
          int pageNum, List<String> locations,
          List<SearchResult> data
  ) {
    List<? extends SearchResult> collect = data.stream()
                                               .filter(x -> locations.contains(x.getLocation()))
                                               .collect(Collectors.toList());
    int pageCount = (int) Math.ceil((double) collect.size() / getPageSize());
    return new FilteredDataResult(pageCount, createFilteredPage(pageNum, collect));
  }

  private <T extends SearchResult> List<T> createFilteredPage(int pageNum, List<T> filteredData) {
    if (pageNum < 0) {
      throw new IndexOutOfBoundsException("Page number starts with 1");
    }
    int start = getPageSize() * pageNum;
    if (filteredData.size() <= start) {
      return filteredData;
    }
    if (filteredData.size() < start + getPageSize()) {
      return filteredData.subList(start, filteredData.size());
    } else {
      return filteredData.subList(start, start + getPageSize());
    }
  }

  private int getPageSize() {
    return pageSize == 0 ? INIT_PAGE_SIZE : pageSize;
  }

  private <T> T getRandomValueFromList(List<T> lst, boolean forFilter) {
    if (lst.isEmpty()) throw new RuntimeException("Couldn't create mock data. Error 1001");
    if (lst.size() == 1) return lst.get(0);
    int current = random.nextInt(lst.size());
    if (forFilter) {
      return lst.get(current == rEmptyLocation ? rFullLocation : current);
    } else {
      return lst.get(current);
    }
  }

  private <T> T getPreConfiguredRandomValueFromList(List<T> lst, boolean forFilter, final int baseId) {
    if (lst.isEmpty()) throw new RuntimeException("Couldn't create mock data. Error 1001");
    if (lst.size() == 1) return lst.get(0);
    int current = (lst.size() - 1) % baseId;
    if (forFilter) {
      return lst.get(current == rEmptyLocation ? rFullLocation : current);
    } else {
      return lst.get(current);
    }
  }
  //</editor-fold>

  //<editor-fold desc="Mocks for Search">
  private FilterDto.Category mockCategory() {
    return new FilterDto.Category()
            .setName("Category #1")
            .setItems(Arrays.asList(
                    new FilterDto.Item("filter item 1", 100),
                    new FilterDto.Item("filter item 2", 200),
                    new FilterDto.Item("filter item 3", 300)
            ));
  }

  private DataSearchResult createDataSearchResult(int dataIterator) {
    return new DataSearchResult(
            "data",
            getRandomValueFromList(mocks.getLogo(), false),
            getRandomValueFromList(mocks.getCompanyUrl(), false),
            getRandomValueFromList(mocks.getPprName(), false),
            getRandomValueFromList(mocks.getPprName(), false),
            Integer.toString(dataIterator),
            getRandomValueFromList(mocks.getDescription(), false).substring(0, 20),
            getRandomValueFromList(mocks.getLocation(), true)
    );
  }

  private PprSearchResult createPprSearchResult(int dataIterator) {
    return new PprSearchResult(
            "ppr",
            getRandomValueFromList(mocks.getLogo(), false),
            getRandomValueFromList(mocks.getCompanyUrl(), false),
            getRandomValueFromList(mocks.getPprName(), false),
            Integer.toString(dataIterator),
            "sustainability",
            "availability",
            getRandomValueFromList(mocks.getLocation(), true)
    );
  }

  private String generateNextServiceId(int dataIterator) {
    return String.format("%d-%d", dataIterator + 1, dataIterator + 1);
  }


  private ServiceSearchResult createServiceSearchResult(final String serviceId) {
    final AllInfoFromServiceId serviceInfo = AllInfoFromServiceId.getAllInfoFromServiceId(serviceId);

    return new ServiceSearchResult(
            serviceInfo.getServiceType(),
            getRandomValueFromList(mocks.getLogo(), false),
            String.format("%s (%s)",
                    getPreConfiguredRandomValueFromList(mocks.getPprName(), false,
                            Integer.parseInt(serviceInfo.getPprId())),
                    serviceId
            ),
            serviceId,
            String.format("%s (%s)",
                    getRandomValueFromList(mocks.getPprName(), false),
                    serviceInfo.getPprId()
            ),
            getRandomValueFromList(mocks.getCompanyUrl(), false),
            "stack",
            "security",
            getRandomValueFromList(mocks.getLocation(), true),
            getRandomValueFromList(mocks.getPreviewImg(), false),
            getRandomValueFromList(mocks.getDescription(), false)
    );
  }

  private ServiceDetails createServiceDetails(final String id, int r, final List<DependendServiceDetails> dependents) {
    return new ServiceDetails(
            id,
            getRandomValueFromList(mocks.getPprName(), false),
            getRandomValueFromList(mocks.getPreviewImg(), false),
            getRandomValueFromList(mocks.getLogo(), false),
            getRandomValueFromList(mocks.getPprName(), false),
            getRandomValueFromList(mocks.getCompanyUrl(), false),
            getRandomValueFromList(mocks.getDescription(), false),
            "features",
            "stack",
            "security",
            mocks.getLocation().get(r),
            mocks.getLocationFlag().get(r),
            LocalDate.now().minusDays(random.nextInt(60)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            String.format("Category #%s", random.nextInt(10)),
            mocks.getTags(),
            "term of use",
            dependents
    );
  }

  private DependendServiceDetails createDependendServiceDetails(final String childServiceId) {
    final AllInfoFromServiceId info = AllInfoFromServiceId.getAllInfoFromServiceId(childServiceId);
//    final int baseId = random.nextInt(100);
//    final int childLastId = lastDigit(childServiceId);
//    final String id = String.valueOf(baseId);
//    final int availableServicesNbr = childLastId + 1;
//    final boolean isSelected = childLastId == 1;
    return new DependendServiceDetails(
            childServiceId,
            getRandomValueFromList(mocks.getPprName(), false),
            getRandomValueFromList(mocks.getPreviewImg(), false),
            getRandomValueFromList(mocks.getLogo(), false),
            getRandomValueFromList(mocks.getPprName(), false),
            getRandomValueFromList(mocks.getCompanyUrl(), false),
            getRandomValueFromList(mocks.getDescription(), false),
            "features",
            "stack",
            "security",
            mocks.getLocation().get(determineLocationIdxByServiceId(childServiceId)),
            mocks.getLocationFlag().get(determineLocationIdxByServiceId(childServiceId)),
            LocalDate.now().minusDays(random.nextInt(60)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            String.format("Category #%s", random.nextInt(10)),
            mocks.getTags(),
            "term of use",
            info.getSlotId(),
            info.isIncludedInComposite()
    );
  }
  //</editor-fold>
}

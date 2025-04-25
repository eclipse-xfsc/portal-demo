package eu.gaia_x.demo.admin.util;

import eu.gaia_x.demo.admin.dto.FilterResult;
import eu.gaia_x.demo.admin.dto.PartItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SortAndFilterHelper {

    private static final int PAGE_SIZE = 10;

    public FilterResult sortAndFilterWithPaging(HttpServletRequest request,
                                                MultiValueMap<String, String> map,
                                                List<? extends PartItem> items,
                                                String endpoint) {

        log.info("1 =========> " + items.size());
        List<String> regType = map.getOrDefault("registration_type", new ArrayList<>());
        if (!regType.isEmpty()) {
            HashSet<String> filter = new HashSet<>(regType);
            items = items.stream()
                    .filter(p -> filter.contains(p.getType()))
                    .collect(Collectors.toList());
        }
        List<String> rqType = map.getOrDefault("request_type", new ArrayList<>());
        if (!rqType.isEmpty()) {
            HashSet<String> filter = new HashSet<>(rqType);
            items = items.stream()
                    .filter(p -> filter.contains(p.getType()))
                    .collect(Collectors.toList());
        }
        List<String> location = map.getOrDefault("location", new ArrayList<>());
        if (!location.isEmpty()) {
            HashSet<String> filter = new HashSet<>(location);
            items = items.stream()
                    .filter(p -> filter.contains(p.getLocation()))
                    .collect(Collectors.toList());
        }
        List<String> locCode = map.getOrDefault("loc_code", new ArrayList<>());
        if (!locCode.isEmpty()) {
            HashSet<String> filter = new HashSet<>(locCode);
            items = items.stream()
                    .filter(p -> filter.contains(p.getLocation()))
                    .collect(Collectors.toList());
        }
        List<String> sort = map.getOrDefault("sort_field", new ArrayList<>());
        List<String> sortDir = map.getOrDefault("sort_direction", new ArrayList<>());
        if (!sort.isEmpty()) {
            String direction = sortDir.isEmpty() ? "ASC" : sortDir.get(0);
            Comparator<PartItem> comparator = SortingParticipantsEnum.getComparatorByParam(sort.get(0), direction);
            items = items.stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
        }
        log.info("2 =========> " + items.size());
        return paging(request, items, map.getOrDefault("page", new ArrayList<>()), endpoint);
    }

    private FilterResult paging(HttpServletRequest request,
                                List<? extends PartItem> fatList,
                                List<String> pageParam,
                                String endpoint) {
        FilterResult result = new FilterResult();

        int pageNum = pageParam.isEmpty() ? 0 : Integer.parseInt(pageParam.get(0));
        int pageCount = getPageCount(fatList);
        result.setPageCount(pageCount);

        if (pageNum < 0 || pageNum > pageCount)
            return new FilterResult(new ArrayList<>(), -1, "", "");

        int start = PAGE_SIZE * pageNum;
        if (fatList.size() < start)
            return new FilterResult(new ArrayList<>(), -1, "", "");

        if (fatList.size() < start + PAGE_SIZE) {
            result.setItems(fatList.subList(start, fatList.size()));
        } else {
            result.setItems(fatList.subList(start, start + PAGE_SIZE));
        }

        int nextPage = pageNum + 1;
        int prevPage = pageNum - 1;

        if (nextPage < pageCount) {
            result.setNext(preparePageLink(request.getQueryString(), nextPage, endpoint));
        }
        if (prevPage > -1) {
            result.setPrev(preparePageLink(request.getQueryString(), prevPage, endpoint));
        }

        return result;
    }

    private int getPageCount(List<? extends PartItem> fatList) {
        double pageCountDouble = fatList.size() / (double) PAGE_SIZE;
        System.out.printf("double pageCountDouble = %s / %s = %s\n", fatList.size(), (double) PAGE_SIZE, pageCountDouble);
        int pageCountInt = fatList.size() / PAGE_SIZE;
        System.out.printf("int pageCountInt = %s mod %s = %s\n", fatList.size(), PAGE_SIZE, pageCountInt);
        int pc = pageCountDouble > pageCountInt ? (int) Math.ceil(pageCountDouble) : pageCountInt;
        System.out.printf("int pageCount = %s > %s ? %s : %s = %s\n",
                pageCountDouble, pageCountInt, (int) Math.ceil(pageCountDouble), pageCountInt, pc);
        return pc;
    }

    private String preparePageLink(String queryString, int pageNumber, String endpoint) {
        String result;
        if (queryString == null || queryString.isEmpty()) {
            result = String.format(endpoint, 2, "");
        } else {
            log.info("QUERY STRING: " + queryString);
            queryString = queryString.replaceAll("page=\\d+&", "");
            queryString = queryString.replaceAll("&page=\\d+", "");
            queryString = queryString.replaceAll("page=\\d+", "");
            log.info("QUERY STRING: " + queryString);
            result = String.format(endpoint, pageNumber, queryString)
                    .replaceAll("&&", "&");
        }
        return result.endsWith("&")
                ? result.substring(0, result.length() - 1)
                : result;
    }

}

package eu.gaia_x.demo.lcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.gaia_x.demo.dashboard.model.*;
import eu.gaia_x.demo.lcm.model.GetServicesConfigRq;
import eu.gaia_x.demo.lcm.model.ServicesConfigResponse;
import eu.gaia_x.demo.lcm.model.ServicesResponse;
import eu.gaia_x.demo.lcm.model.UploadConfigResponse;
import eu.gaia_x.demo.lcm.util.ItemsStash;
import eu.gaia_x.demo.lcm.util.Template;
import eu.gaia_x.demo.utils.JsonUtil;
import eu.gaia_x.demo.utils.JwtDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
@RestController
@Log4j2
@RequestMapping("/demo/api/lcm-service")
public class LcmController {

    private final Random random = new Random();
    @Autowired
    private ItemsStash stash;


    @GetMapping(value = "/service/overview")
    public ResponseEntity<?> serviceOverview(HttpServletRequest request, @RequestParam("serviceId") String sid) {
        ServicesResponse.ServiceOverviewDto[] services = IntStream.range(1, 3)
                .mapToObj(i -> {
                    ServicesResponse.ApplicableLcm[] appLcms = IntStream.range(1, 5)
                            .mapToObj(j -> new ServicesResponse.ApplicableLcm("service" + j, "LCM Service Name", "Description"))
                            .toArray(ServicesResponse.ApplicableLcm[]::new);
                    return new ServicesResponse.ServiceOverviewDto(
                            String.format("%s-%s", sid, i), "Service Name #" + i, appLcms
                    );
                }).toArray(ServicesResponse.ServiceOverviewDto[]::new);
        ServicesResponse servicesResponse = new ServicesResponse();
        servicesResponse.setServices(services);
        return ResponseEntity.ok(servicesResponse);
    }

    @PostMapping(value = "/service/configuration")
    public ResponseEntity<?> lcmConfiguration(HttpServletRequest request, @RequestBody GetServicesConfigRq rq) {
        ServicesConfigResponse servicesResponse = new ServicesConfigResponse();
        ServicesConfigResponse.Field[] fields = IntStream.range(1, 5)
                .mapToObj(i -> new ServicesConfigResponse.Field("field_" + i, "label_" + i))
                .toArray(ServicesConfigResponse.Field[]::new);
        ServicesConfigResponse.ServiceConfig[] services = new ServicesConfigResponse.ServiceConfig[rq.getServices().length];
        for (int i = 0; i < services.length; i++) {
            services[i] = new ServicesConfigResponse.ServiceConfig
                    (rq.getServices()[i].getServiceId(), rq.getServices()[i].getLcmServiceId(), fields);
        }
        servicesResponse.setServices(services);
        return ResponseEntity.ok(servicesResponse);
    }

    @PostMapping(value = "/service")
    public ResponseEntity<?> updateConfiguration(HttpServletRequest request, @RequestBody Object rq) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/templates")
    public ResponseEntity<Resource> download(@RequestHeader HttpHeaders headers,
                                             @RequestBody GetServicesConfigRq rq) {
        try {
            byte[] bytes = Template.TEMPLATE_1.getBytes(StandardCharsets.UTF_8);
            Resource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
            log.info("========================> TEMPLATES: " + bytes.length);
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(bytes.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            log.error("ERROR :: " + e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/configuration", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createServices(@RequestPart(value = "file") MultipartFile file) {
        log.info("START: " + file.getOriginalFilename());
        UploadConfigResponse.Service[] services = IntStream.range(1, 3)
                .mapToObj(i -> new UploadConfigResponse.Service("id_" + i, "name_" + i, new UploadConfigResponse.Field[] {
                        new UploadConfigResponse.Field("id_1", "label_1", "value_1"),
                        new UploadConfigResponse.Field("id_2", "label_2", "value_2")
                })).toArray(UploadConfigResponse.Service[]:: new);
        log.info("FINISH");
        return ResponseEntity.ok(new UploadConfigResponse(services));
    }

    @GetMapping(value = "/service/{id}/logs")
    public ResponseEntity<?> getLogs(@RequestHeader HttpHeaders headers, @PathVariable String id) {
        log.info("getLogs for {}", id);
        try {
            byte[] bytes = Template.LOG.getBytes(StandardCharsets.UTF_8);
            Resource resource = new InputStreamResource(new ByteArrayInputStream(bytes));

            headers.set(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=logs_" + System.currentTimeMillis() + ".log");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(bytes.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            log.error("ERROR :: " + e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/transactions")
    public ResponseEntity<TransactionResponse> getTransactions() {
        List<TransactionItem> items = createRandomItems(x -> new TransactionItem(
                String.valueOf(x),
                "Title #" + x,
                "Subtitle #" + x,
                LocalDate.now().minusDays(random.nextInt(100)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        ));
        return ResponseEntity.ok(new TransactionResponse(items));
    }

    @GetMapping("/datasets")
    public ResponseEntity<DatasetResponse> getDatasets(@RequestHeader HttpHeaders headers) {
        List<DatasetItem> items = isOwner(headers)
                ? stash.getPprDatasets()
                : stash.getPcrDatasets();
        return ResponseEntity.ok(new DatasetResponse(items));
    }

    @GetMapping("/sp")
    public ResponseEntity<eu.gaia_x.demo.dashboard.model.ServicesResponse> getSP(@RequestHeader HttpHeaders headers) {
        List<ServiceItem> items = stash.getSp();
        return ResponseEntity.ok(new eu.gaia_x.demo.dashboard.model.ServicesResponse(items));
    }

    @GetMapping("/services")
    public ResponseEntity<eu.gaia_x.demo.dashboard.model.ServicesResponse> getServices(@RequestHeader HttpHeaders headers) {
        List<ServiceItem> items = isOwner(headers)
                ? stash.getPprServices()
                : stash.getPcrServices();
        return ResponseEntity.ok(new eu.gaia_x.demo.dashboard.model.ServicesResponse(items));
    }

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics() {
        List<Statistics.Chart> budgetCharts = new ArrayList<>();
        List<Statistics.Chart> usageCharts = new ArrayList<>();

        int month = 30;
        String[] x = new String[month];
        for (int i = 0; i < month; i++) {
            x[i] = LocalDate.now().minusDays(month + 1 - i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        List<String> colors = Arrays.asList(
                "#8dd3c7", "#ffffb3", "#bebada", "#fb8072",
                "#80b1d3", "#fdb462", "#b3de69", "#fccde5",
                "#d9d9d9", "#bc80bd", "#ccebc5", "#ffed6f");
        for (int i = 0; i < 5; i++) {
            double[] budgetY = new double[month];
            double[] usageY = new double[month];
            for (int j = 0; j < month; j++) {
                budgetY[j] = random.nextInt(10) + (random.nextBoolean() ? 0.5 : 0);
                usageY[j] = random.nextInt(10) + (random.nextBoolean() ? 0.5 : 0);
            }

            Map<String, String> budgMarker = new HashMap<>();
            budgMarker.put("color", colors.get(i));
            budgetCharts.add(new Statistics.Chart(x, budgetY, "scatter", budgMarker, "lines+markers", true, "service " + i));

            Map<String, String> usgMarker = new HashMap<>();
            usgMarker.put("color", colors.get(colors.size() - 1 - i));
            usageCharts.add(new Statistics.Chart(x, usageY, "bar", usgMarker, null, true, "service " + i));
        }
        Statistics.Plot budgetPerDay = new Statistics.Plot("Budget per day", budgetCharts.toArray(Statistics.Chart[]::new));
        Statistics.Plot usagePerDay = new Statistics.Plot("Usage per day", usageCharts.toArray(Statistics.Chart[]::new));
        return ResponseEntity.ok(new Statistics(new Statistics.Plot[]{budgetPerDay, usagePerDay}));
    }

    private <T> List<T> createRandomItems(Function<Integer, T> func) {
        int count = random.nextInt(20) + 1;
        List<T> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lst.add(func.apply(i + 1));
        }
        return lst;
    }

    private boolean isOwner(HttpHeaders headers) {
        headers.forEach((key, value) -> log.info("HEADER: " + key + "; VALUES: " + value));
        String authorization = headers.getFirst("authorization");
        if (authorization != null) {
            log.info("read role from token");
            JwtDto jwtDto = JsonUtil.readTokenIntoClass(authorization, JwtDto.class);
            log.info("JWT object: {}", jwtDto);
            return jwtDto.getRealmAccess().getRoles().contains("gaiax-ppr");
        } else {
            log.info("couldnot read role from token");
            throw new RuntimeException("Not authorized");
        }
    }
}

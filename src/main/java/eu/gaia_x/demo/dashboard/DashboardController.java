package eu.gaia_x.demo.dashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.gaia_x.demo.common.ErrorDto;
import eu.gaia_x.demo.dashboard.model.*;
import eu.gaia_x.demo.lcm.util.ItemsStash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

@Slf4j
@RestController
@RequestMapping("/demo/api/dashboard")
public class DashboardController {

    @Autowired
    private ItemsStash stash;
    private final Random random = new Random();

    @GetMapping("/news")
    public ResponseEntity<NewsResponse> getNews() {
        List<NewsItem> items = createRandomItems(x -> new NewsItem(
                String.valueOf(x),
                "Title #" + x,
                "Subtitle #" + x,
                LocalDate.now().minusDays(random.nextInt(100)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        ));
        NewsResponse body = new NewsResponse(items);
        log.info("BODY ====> " + body);
        return ResponseEntity.ok(body);
    }

    @PostMapping(value = {"/datasets", "/services", "/sp"})
    public ResponseEntity<?> activate(HttpServletRequest request, @RequestBody ActivateRq rq) {
        log.info("endpoint: {}, request: {}", request.getRequestURI(), rq);
        ErrorDto errorDto = stash.activateDeactivateDataset(rq);
        return errorDto == null
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body(errorDto.getMessage());
    }

    private <T> List<T> createRandomItems(Function<Integer, T> func) {
        int count = random.nextInt(20) + 1;
        List<T> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lst.add(func.apply(i + 1));
        }
        return lst;
    }
}

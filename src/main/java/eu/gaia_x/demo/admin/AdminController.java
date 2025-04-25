package eu.gaia_x.demo.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.gaia_x.demo.admin.dto.*;
import eu.gaia_x.demo.admin.util.AdminRandomizer;
import eu.gaia_x.demo.admin.util.SortAndFilterHelper;
import eu.gaia_x.demo.common.ErrorDto;
import eu.gaia_x.demo.onboarding.model.UserRegistrationRequest;
import eu.gaia_x.demo.utils.ReadFileUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Slf4j
@SuppressWarnings("unused")
@RestController
@RequestMapping("/demo/api/admin")
public class AdminController {

  private final AdminRandomizer randomizer;
  private final SortAndFilterHelper helper;

  @Autowired
  public AdminController(AdminRandomizer randomizer) {
    this.randomizer = randomizer;
    this.helper = new SortAndFilterHelper();
  }

  //<editor-fold desc="Left Menu">
  @GetMapping("/management/request-types")
  public ResponseEntity<FilterDto> getManagementRequestTypes() {
    return ResponseEntity.ok(randomizer.getFilterItems(false));
  }

  @GetMapping("/management/locations")
  public ResponseEntity<LocationFilterDto> getManagementLocationFilter() {
    return ResponseEntity.ok(randomizer.getLocationFilterItems(false));
  }

  @GetMapping("/pr/registration-types")
  public ResponseEntity<FilterDto> getParticipantsRegisterTypes() {
    return ResponseEntity.ok(randomizer.getFilterItems(true));
  }

  @GetMapping("/pr/locations")
  public ResponseEntity<LocationFilterDto> getParticipantsLocationFilter() {
    return ResponseEntity.ok(randomizer.getLocationFilterItems(true));
  }
  //</editor-fold>

  //<editor-fold desc="Right Menu">
  @GetMapping("/pr/registrations/search")
  public ResponseEntity<FilterResult> getSortedParticipants(@RequestParam MultiValueMap<String, String> map,
                                                            HttpServletRequest request) {
    List<Participant> collect = randomizer.getParticipants();
    FilterResult result = helper.sortAndFilterWithPaging(request, map, collect, "/admin/management/requests/search" +
            "?page=%s&%s");
    if (result.getPageCount() == -1) return ResponseEntity.badRequest().build();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/management/requests/search")
  public ResponseEntity<FilterResult> getSortedParticipationRequests(@RequestParam MultiValueMap<String, String> map,
                                                                     HttpServletRequest request) {
    List<PartRequest> collect = randomizer.getParticipantRequests();
    FilterResult result = helper.sortAndFilterWithPaging(request, map, collect, "/admin/management/requests/search" +
            "?page=%s&%s");
    if (result.getPageCount() == -1) return ResponseEntity.badRequest().build();
    return ResponseEntity.ok(result);
  }

  @PostMapping("/management/requests/accept")
  public ResponseEntity<?> acceptRequest(@RequestBody Map<String, ?> map) {
    log.info("Following request was accepted: " + map);
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/management/notarization/requests", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<?> notarizationRequest(
          @RequestParam String details,
          @RequestParam Map<String, MultipartFile> documents
  ) {
    log.info("In notarizationRequest, details: {}, documents:{}", details, documents);
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/management/ocm/requests", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<?> ocmRequest(
          @RequestParam String details,
          @RequestParam Map<String, MultipartFile> documents
  ) {
    log.info("In ocmRequest, details: {}, documents:{}", details, documents);
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/management/sd/requests", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<?> sdRequest(
          @RequestParam String details,
          @RequestParam Map<String, MultipartFile> documents
  ) {
    log.info("In ocmRequest, details: {}, documents:{}", details, documents);
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/management/attachments/accept", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
  public ResponseEntity<?> acceptAttachments(HttpServletRequest request) throws IOException {
    log.info("Try to read attachment: " + request.getHeader("input-file"));
    String fileContent = ReadFileUtil.fromOctet(request).replaceAll("\n", "").replaceAll("\\s+", " ");
    log.info("Input file was read: " + ((fileContent.length() > 20) ? fileContent.substring(0, 20) + "..." :
            "=>" + fileContent + "<="));
    if (fileContent.length() > 0) return ResponseEntity.ok().build();
    return ResponseEntity.badRequest().body(new ErrorDto("", "File content is empty"));
  }

  @GetMapping("/pr/registrations/{id}/details")
  public ResponseEntity<DetailsDto> getRqDetails(HttpServletRequest request, @PathVariable String id) {
    return ResponseEntity.ok(randomizer.createDetails());
  }
  //</editor-fold>

}

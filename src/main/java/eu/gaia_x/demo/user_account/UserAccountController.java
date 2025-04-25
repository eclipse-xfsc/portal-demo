package eu.gaia_x.demo.user_account;

import eu.gaia_x.demo.onboarding.model.UserRegistrationRequest;
import eu.gaia_x.demo.onboarding.util.JwtUtil;
import eu.gaia_x.demo.storage.EmailConfirmationStorage;
import eu.gaia_x.demo.utils.JsonUtil;
import eu.gaia_x.demo.web.auth.AuthStatusParameters;
import eu.gaia_x.demo.web.auth.AuthTokenResponse;
import eu.gaia_x.demo.web.auth.MockIdPDetails;
import eu.gaia_x.demo.web.common.CallStatus;
import eu.gaia_x.demo.web.email.EmailConfirmationParameters;
import eu.gaia_x.demo.web.usracc.*;
import eu.gaia_x.demo.web.vc.MockVCOrganization;
import eu.gaia_x.demo.web.vc.MockVCUser;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@SuppressWarnings("unused")
@Log4j2
@RestController
@RequestMapping(value = {"/demo/api/identity/user-account/api"})
public class UserAccountController {
  private static int counter = 1;

  private final String identityURIExt;
  private final EmailConfirmationStorage emailConfirmationStorage;
  private final boolean useKeycloakAuth;

  public UserAccountController(
          @Autowired EmailConfirmationStorage emailConfirmationStorage,
          @Value("${services.identity.uri.external}") String identityURIExt,
          @Value("${keycloak.auth.use:true}") boolean useKeycloakAuth
  ) {
    this.emailConfirmationStorage = emailConfirmationStorage;
    this.identityURIExt = identityURIExt;
    this.useKeycloakAuth = useKeycloakAuth;
  }

  @PutMapping("/account/provider/create")
  public ResponseEntity<ProviderAccountDetails> addNewProviderAccountData(@RequestBody ProviderAccountDetails rq) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rq);
  }

  @DeleteMapping("/account/provider/delete")
  public ResponseEntity<?> deleteProviderAccountData() {
    log.info("Delete provider account for Gaia-X system");
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }

  @GetMapping("/account/provider")
  public ResponseEntity<ProviderAccountDetails> getProviderAccountData(@RequestHeader HttpHeaders headers) {
    if (!useKeycloakAuth) {
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(new ProviderAccountDetails(
                      "https://cdn-icons-png.flaticon.com/512/147/147142.png",
                      "email@email.com",
                      "CompanyName",
                      "Register",
                      String.format("%s%s%s%s",
                              "Street 45",
                              "34534",
                              "City",
                              "Country"
                      ),
                      "http://company.com",
                      new IndividualContact(
                              "Name",
                              "Surname",
                              "name@web.com",
                              "+34 324 3532"),
                      "certification",
                      "alias",
                      "Local Attestation",
                      "Transparency Register",
                      "1343",
                      "345948349",
                      new DataProviderOfficer(
                              "Name",
                              "Surname",
                              "email@email.com",
                              "+2 345345345"
                      )
              ));
    } else {
      final String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
      if (!StringUtils.hasText(authHeader)) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
      }
      final JSONObject json = JwtUtil.readTokenIntoClass(authHeader);
      log.info("json: {}", json);
      final ProviderAccountDetails rq =
              new ProviderAccountDetails(
                      json.getString("prAva"),
                      json.getString("prEmail"),
                      json.getString("prName"),
                      json.getString("prCR"),
                      String.format("%s, %s, %s, %s",
                              json.getJSONObject("address").getString("postal_code"),
                              json.getJSONObject("address").getString("country"),
                              json.getJSONObject("address").getString("locality"),
                              json.getJSONObject("address").getString("street_address")
                      ),
                      json.getString("prWeb"),
                      new IndividualContact(
                              json.getJSONObject("prIC").getString("name"),
                              json.getJSONObject("prIC").getString("lastName"),
                              json.getJSONObject("prIC").getString("email"),
                              json.getJSONObject("prIC").getString("phone")
                      ),
                      json.getString("prCert"),
                      json.getString("prA"),
                      json.getString("prLA"),
                      json.getString("prTR"),
                      json.getString("prDN"),
                      json.getString("prLEI"),
                      new DataProviderOfficer(
                              json.getJSONObject("prOff").getString("name"),
                              json.getJSONObject("prOff").getString("lastName"),
                              json.getJSONObject("prOff").getString("email"),
                              json.getJSONObject("prOff").getString("phone")
                      )
              );
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(rq);
    }
  }

  @PostMapping("/account/provider/update")
  public ResponseEntity<ProviderAccountDetails> updateProviderAccountData(@RequestBody ProviderAccountDetails rq) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rq);
  }

  @GetMapping("/account/provider/history")
  public ResponseEntity<?> getProviderLoginHistory() {
    List<Map<String, String>> result = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Map<String, String> map = new HashMap<>();
      map.put("id", String.valueOf(110 - i));
      map.put("date", (14 - i) + ".12.2020");
      map.put("time", "10:" + (40 - i) + " am");
      map.put("name", "Provider Name");
      result.add(map);
    }
    Map<String, List<Map<String, String>>> map = new HashMap<>();
    map.put("history", result);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(map);
  }

  @PutMapping("/account/user/create")
  public ResponseEntity<UserAccountDetails> addNewUserAccountData(@RequestBody UserAccountDetails rq) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rq);
  }

  @GetMapping("/account/user")
  public ResponseEntity<UserRegistrationRequest> getUserAccountData(@RequestHeader HttpHeaders headers) {
    if (!useKeycloakAuth) {
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(new UserRegistrationRequest(
                      "Name",
                      "LastName",
                      "email@email.com",
                      "+00 123456789",
                      "Street 0",
                      "123321",
                      "City",
                      "Country"
              ));
    }

    final String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
    if (!StringUtils.hasText(authHeader)) {
      return ResponseEntity
              .status(HttpStatus.UNAUTHORIZED)
              .build();
    }
    //UserAccountDetails rq = JsonUtil.readTokenIntoClass(authHeader, UserAccountDetails.class);
    final JSONObject json = JwtUtil.readTokenIntoClass(authHeader);
    log.info("getUserAccountData, json: {}", json);
    final UserRegistrationRequest rq = new UserRegistrationRequest(
            json.getString("name"),
            json.getString("family_name"),
            json.getString("email"),
            json.getString("prPhone"),
            json.getJSONObject("address").getString("street_address"),
            json.getJSONObject("address").getString("postal_code"),
            json.getJSONObject("address").getString("locality"),
            json.getJSONObject("address").getString("country")
    );
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rq);
  }

  @PostMapping("/account/user/update")
  public ResponseEntity<UserAccountDetails> updateUserAccountData(@RequestBody UserAccountDetails rq) {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(rq);
  }

  @PostMapping("/account/provider/upload_provider_sd")
  public ResponseEntity<?> updateProviderSD(@RequestParam("providerFile") MultipartFile file) {
    log.info("SelftDescription service updateProvider call success");
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

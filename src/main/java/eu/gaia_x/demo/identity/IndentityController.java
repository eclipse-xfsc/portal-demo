package eu.gaia_x.demo.identity;

import eu.gaia_x.demo.onboarding.util.JwtUtil;
import eu.gaia_x.demo.utils.EmailSender;
import eu.gaia_x.demo.storage.EmailConfirmationStorage;
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
@RequestMapping(value = {"/demo/api/identity"})
public class IndentityController {
  private final String identityURIExt;
  @Value("${services.identity.uri_path.email-confirmation-link}")
  private String emailConfirmationLinkPath;

  @Value("${keycloak.auth.use:true}")
  private boolean useKeycloakAuth;

  private final EmailConfirmationStorage emailConfirmationStorage;
  @Autowired
  private EmailSender emailSender;

  @Autowired
  public IndentityController(
          EmailConfirmationStorage emailConfirmationStorage,
          @Value("${services.identity.uri.external}") String identityURIExt
  ) {
    this.emailConfirmationStorage = emailConfirmationStorage;
    this.identityURIExt = identityURIExt;
  }

  @GetMapping("/ext/verify_email_confirmed")
  @ResponseBody
  public CallStatus verifyEmailConfirmed(@RequestParam Map<String, String> allParams) {
    final String email = allParams.get("email");
    log.info("Verification of confirmed email: {}, status: {}", email, emailConfirmationStorage.isConfirmed(email));

    return emailConfirmationStorage.isConfirmed(email) ? CallStatus.SUCCESS : CallStatus.FAIL;
  }

  @GetMapping("/ext/email_confirmation")
  @ResponseBody
  public ModelAndView callEmailConfirmation(ModelMap model, @RequestParam Map<String, String> allParams) {
    final String state = allParams.get("state");
    final String email = allParams.get("email");
    final String redirectURI = allParams.get("redirect_uri");
    emailConfirmationStorage.confirmEmail(email);
    log.info("Confirmed email {} for state: {}", email, state);

    log.info("Redirection to the portal: {}", redirectURI);
    model.addAttribute("state", state);
    model.addAttribute("email", email);
    model.addAttribute("redirect_uri", redirectURI);
    return new ModelAndView(String.format("redirect:%s", redirectURI), model);
  }

  @SuppressWarnings("SameReturnValue")
  @PostMapping("/ext/email_confirmation_service")
  @ResponseBody
  public CallStatus callEmailConfirmationService(@RequestBody Map<String, String> raw) {
    log.info("Call for email confirmation service: {}", raw);
    final EmailConfirmationParameters p = EmailConfirmationParameters.from(raw);
    emailConfirmationStorage.addEmail(p.getEmail());
    log.info("Sending email with confirmation link: {}{}?state={}&email={}&redirect_uri={}",
            identityURIExt, emailConfirmationLinkPath, p.getState(), p.getEmail(), p.getRedirectURI());
    String url = String.format("%s%s?state=%s&email=%s&redirect_uri=%s",
            identityURIExt, emailConfirmationLinkPath, p.getState(), p.getEmail(), p.getRedirectURI());
    emailSender.sendEmailRegistrationMessage(raw.get("email"), url);
    return CallStatus.SUCCESS;
  }


  @GetMapping("/auth/identity/mock_user")
  @ResponseBody
  public MockVCUser mockVCUser() {
    final MockVCUser vcUser = MockVCUser.of("Jane@Doe.com", "Jane Doe", "555",
            "sasame 1", "12345", "Berlin");
    log.info("Mock VC of user: {}", vcUser);
    return vcUser;
  }

  @GetMapping("/auth/identity/mock_organization")
  @ResponseBody
  public MockVCOrganization mockVCOrganization() {
    final MockVCOrganization vcOrganization =
            MockVCOrganization.of("wildCoyote@acme.com", "Wild Coyote", "555",
                    "sasame 1", "54321", "Berlin");
    log.info("Mock VC of organization: {}", vcOrganization);
    return vcOrganization;
  }

  @GetMapping("/user/registration/mock_registration_qr")
  @ResponseBody
  public ResponseEntity<String> mockRegistrationQR() {
    final String response = "http://upload.wikimedia" +
            ".org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia" +
            ".svg/250px-QR_code_for_mobile_English_Wikipedia.svg.png";
    log.info("Return registratoin QR-Code: {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/auth/identity/provider")
  @ResponseBody
  public ResponseEntity<List<MockIdPDetails>> mockRegistrationIdPList() {
    final MockIdPDetails idp1 = MockIdPDetails.of("Identity Service Provider 1", "http://gaia-x.portal" +
            ".ext:8085/register/displayVC?type=organization", "uri_logo");
    final MockIdPDetails idp2 = MockIdPDetails.of("Identity Service Provider 2", "#", "uri_logo");
    final MockIdPDetails idp3 = MockIdPDetails.of("ID Union", "#", "uri_logo");
    final MockIdPDetails idp4 = MockIdPDetails.of("Identity Service Provider 4", "#", "uri_logo");
    final MockIdPDetails idp5 = MockIdPDetails.of("Identity Service Provider 5", "#", "uri_logo");
    List<MockIdPDetails> response = new ArrayList<MockIdPDetails>();
    response.add(idp1); response.add(idp2); response.add(idp3); response.add(idp4); response.add(idp5);
    log.info("Return IdentityProvider Details List: {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("/api/upload_provider")
  public ResponseEntity<?> updateProviderSD(@RequestParam("providerFile") MultipartFile file) {
    log.info("SelftDescription service updateProvider call sucess");
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/user-account/api/account/provider/users")
  @ResponseBody
  public ResponseEntity<List<CredentialUser>> mockRegistrationIdPList(
          @RequestHeader HttpHeaders headers
  ) {
    final List<CredentialUser> response;
    if (!useKeycloakAuth) {
      final CredentialUser user1 =
              new CredentialUser("1", "Fname1",
                      "Lname1", "PPR_USER", "email1@domain.com", "uname1"
              );
      final CredentialUser user2 = new CredentialUser("2", "Fname2",
              "Lname2", "PPR_USER", "email2@domain.com",
              "uname2"
      );
      final CredentialUser user3 = new CredentialUser("3", "Fname3",
              "Lname3", "PPR_EDITOR", "email3@domain.com",
              "uname3"
      );
      final CredentialUser user4 = new CredentialUser("4", "Fname4",
              "Lname4", "PPR_EDITOR", "email4@domain.com",
              "uname4"
      );
      response = List.of(user1, user2, user3, user4);
    } else {
      final String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
      if (!StringUtils.hasText(authHeader)) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
      }
      final JSONObject json = JwtUtil.readTokenIntoClass(authHeader);
      log.info("json: {}", json);
      response = List.of(
              new CredentialUser(
                      "1",
                      json.getJSONObject("prIC").getString("name"),
                      json.getJSONObject("prIC").getString("lastName"),
                      "PPR_EDITOR",
                      json.getJSONObject("prIC").getString("email"),
                      String.format("%s.%s",
                              json.getJSONObject("prIC").getString("name"),
                              json.getJSONObject("prIC").getString("lastName")
                      )
              ),
              new CredentialUser(
                      "2",
                      json.getJSONObject("prOff").getString("name"),
                      json.getJSONObject("prOff").getString("lastName"),
                      "PPR_EDITOR",
                      json.getJSONObject("prOff").getString("email"),
                      String.format("%s.%s",
                              json.getJSONObject("prOff").getString("name"),
                              json.getJSONObject("prOff").getString("lastName")
                      )
              )
      );
    }

    log.info("in /user-account/api/account/provider/users, response: {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/user-account/api/account/provider/users/{userId}")
  @ResponseBody
  public ResponseEntity<?> updateUsers(
          @PathVariable(value = "userId") String userId, @RequestBody CredentialUser rq
  ) {
    log.info("user credentials {} updated with the following details : {}", userId, rq);
    rq.setId(userId);
    return ResponseEntity.status(HttpStatus.OK).body(rq);
  }

  @PostMapping("/user-account/api/account/provider/users")
  @ResponseBody
  public ResponseEntity<?> addUsers(@RequestBody CredentialUser rq) {
    Random random = new Random();
    rq.setId(String.valueOf(random.nextInt()));
    rq.setUserName(rq.getEmail());
    rq.setEmail(rq.getEmail());
    rq.setFirstName(rq.getFirstName());
    rq.setLastName(rq.getLastName());
    rq.setRole(rq.getRole());
    log.info("New user credentials with the following details : {}", rq);
    return ResponseEntity.status(HttpStatus.OK).body(rq);
  }

  @DeleteMapping("/user-account/api/account/provider/users/{userId}")
  @ResponseBody
  public ResponseEntity<?> deleteUsers(
          @PathVariable(value = "userId") String userId
  ) {
    log.info("user credentials {} delete account", userId);
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }


}

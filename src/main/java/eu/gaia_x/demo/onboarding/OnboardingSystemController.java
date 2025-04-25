package eu.gaia_x.demo.onboarding;


import eu.gaia_x.demo.common.ErrorDto;
import eu.gaia_x.demo.identity.wallet.QrInfoResponse;
import eu.gaia_x.demo.onboarding.model.*;
import eu.gaia_x.demo.onboarding.util.JwtUtil;
import eu.gaia_x.demo.onboarding.util.KeycloakAuthResponse;
import eu.gaia_x.demo.utils.EmailSender;
import eu.gaia_x.demo.web.auth.AuthStatusParameters;
import eu.gaia_x.demo.web.auth.AuthTokenResponse;
import eu.gaia_x.demo.web.common.CallStatus;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.keycloak.adapters.OidcKeycloakAccount;
import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulates all calls related to starting of Onboarding process
 * after user have confirmed email - we are not sure will Identity System start it
 * or that should be initiated by our onboarding MS
 */

@Log4j2
@RestController
@RequestMapping(value = {"/demo/api/onboarding"})
public class OnboardingSystemController {
  private static int counter = 1;

  @Value("${services.identity.uri.external}")
  String uriExternal;
  @Autowired
  private EmailSender emailSender;

  @Autowired
  @Qualifier("kcSrv")
  public WebClient kcSrv;

  @Value("${keycloak.resource}")
  private String clientId;
  @Value("${ext.keycloak.client_secret}")
  private String clientSecret;

  final private Map<String, KeycloakAuthResponse> jwtMap;

  public OnboardingSystemController() {
    jwtMap = new HashMap<>();
  }

  @PostMapping("/start_onboarding")
  @ResponseBody
  public CallStatus startOnboardingAfterEmailConfirmation(
          @RequestBody Map<String, String> raw,
          @Value("${services.portal.uri.external}") String portalURI,
          @Value("${services.portal.uri_path.wizard_register_viadid}") String wizardPath

  ) {
    log.info("Onboarding process started: {}", raw);

    log.info("Upon completion DID information and link {} should be sent to email {}",
            String.format("%s%s?state=%s", portalURI, wizardPath, raw.get("state")), raw.get("email"));
    emailSender.sendEmailRegistrationMessage(raw.get("email"), String.format("%s%s?state=%s", portalURI, wizardPath,
            raw.get("state")));
    return CallStatus.SUCCESS;
  }

  @PostMapping("/ext/access_token")
  @ResponseBody
  public AuthTokenResponse getAccessToken(@RequestBody Map<String, String> raw) {
    log.info("getAccessToken, raw: {}", raw);

    final AuthStatusParameters p = AuthStatusParameters.from(raw);

    if (counter < 5 ||
            (counter > 5 && counter < 10)
    ) {
      counter++;
      return AuthTokenResponse.of(p.getState(),
              null,
              CallStatus.WAIT);
    } else if (counter == 5) {
      counter++;
      return AuthTokenResponse.of(p.getState(),
              "eyJraWQiOiJoMHJQdGJjWk5INDV2dC0tcVhPRy1TLTNhUEZlMjJTd1hoVmtqNXEtbWI4IiwiYWxnIjoiUlMyNTYifQ" +
                      ".eyJzdWIiOiIwMHU0bHZ3OTNxQUpieVdwVjVkNyIsIm5hbWUiOiJZdXJpIEJlbG9nbGF6b3YiLCJlbWFpbCI6Inl1cmkuYmVsb2dsYXpvdkB1bHRyYXRlbmRlbmN5LmNvbSIsInZlciI6MSwiaXNzIjoiaHR0cHM6Ly9kZXYtNDU1NzY5Mjgub2t0YS5jb20vb2F1dGgyL2RlZmF1bHQiLCJhdWQiOiIwb2E0bHlja2ZodW1BeWlUeTVkNyIsImlhdCI6MTY0OTc2ODM3NSwiZXhwIjoxNjQ5NzcxOTc1LCJqdGkiOiJJRC5rUUN5SnZNMjZZclhEZHloa1RGTnlRV0U4N3NoVFFyUGczMHVjaTV2Q1JzIiwiYW1yIjpbInB3ZCJdLCJpZHAiOiIwMG80bHZ3OHg0aHZldGdBdTVkNyIsIm5vbmNlIjoiVU4xcjJZNzdWaFE5azhiSmlycWZfajdsTEFfTTVwMW1zd2FidFlBeklmYyIsInByZWZlcnJlZF91c2VybmFtZSI6Inl1cmkuYmVsb2dsYXpvdkB1bHRyYXRlbmRlbmN5LmNvbSIsImF1dGhfdGltZSI6MTY0OTc2ODM3MywiYXRfaGFzaCI6Ik00RDFwTk9kVUZzX0llWmlDWWtDU0EifQ.Du3oSLWVOiRYMzwWvrfVNcTaCZk4_5AL8iWGeChXBRDqk1Ub3aTew1gS4zqzz9e_Ko4YUC700SxijyLaYjJRr0WvWfO_9NUWbTMM-6iZw8PqWgxJku6C_e1DFyReZlLjcRypNg1EtiwYK77jEjiSQe-VDVf5YS1FEG8U936PoHK72g_FypN0sX61hls8bts6XTiUfQU4O85t7X6g5YUZ1OHQrFPv0SsfVKeGj-6NZezbDTKmrY9DMdY9qKlVW4c4smtvPqHRkxx1v0D1toNbiczQuB4hbQVgT5R2GCegEQtzmBQNBOYBhItIYp-6Y__6DJl87HzgKIxJcw6vhTSF4A",
              CallStatus.SUCCESS);
    } else if (counter == 10) {
      counter = 1;
      return AuthTokenResponse.of(p.getState(),
              null,
              CallStatus.FAIL);
    }

    throw new AssertionError("Never goes here");
  }

  @GetMapping("/ext/auth/{role}/{session}")
  public ResponseEntity<String> authFR(
          @PathVariable("role") String role,
          @PathVariable("session") String session
  ) {
    if (role.equals("gaiax-vr")) {
      jwtMap.put(session, null);
    } else {
      jwtMap.put(session, getAccessTokenFromKC(role));
    }

    return ResponseEntity.ok("Please, return to the Portal");
  }

  @GetMapping("/ext/auth/login-mock/{session}")
  public ResponseEntity<String> mockForLogin(@PathVariable("session") String session) {
    final StringBuilder strB = new StringBuilder();
    strB.append("<h1>Welcome to authentication/authorization mock!</h1>");
    strB.append("<p>Please, click on any link for authentication with proper role <br>");

    strB.append("<h2>Login test</h2>");
    strB.append("<ul>");
    strB.append("<li>");
    strB.append(String.format("<a href='/demo/api/onboarding/ext/auth/%s/%s'>Login as FR</a>", "gaiax-fr", session));
    strB.append("<li>");
    strB.append(String.format("<a href='/demo/api/onboarding/ext/auth/%s/%s'>Login as PPR</a>", "gaiax-ppr", session));
    strB.append("<li>");
    strB.append(String.format("<a href='/demo/api/onboarding/ext/auth/%s/%s'>Login as PCR</a>", "gaiax-pcr", session));
    strB.append("<li>");
    strB.append(String.format("<a href='/demo/api/onboarding/ext/auth/%s/%s'>Failed login</a>", "gaiax-vr", session));
    strB.append("</ul>");


    strB.append("<h2>Onboarding test</h2>");
    strB.append("<ul>");
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Provider (success)</a>",
                    "gaiax-ppr-first-did",
                    session
            )
    );
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Provider (in process)</a>",
                    "gaiax-ppr",
                    session
            )
    );
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Provider (fail)</a>",
                    "gaiax-vr",
                    session
            )
    );
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Customer (success)</a>",
                    "gaiax-pcr-first-did",
                    session
            )
    );
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Customer (in process)</a>",
                    "gaiax-pcr",
                    session
            )
    );
    strB.append("<li>");
    strB.append(
            String.format(
                    "<a href='/demo/api/onboarding/ext/auth/%s/%s'>Onboarding Customer (fail)</a>",
                    "gaiax-vr",
                    session
            )
    );
    strB.append("</ul>");


    return ResponseEntity.ok(
            strB.toString()
    );
  }

  private KeycloakAuthResponse getAccessTokenFromKC(final String username) {
    return
            kcSrv.post()
                 .uri("/realms/gaiax_realm/protocol/openid-connect/token")
                 .body(
                         BodyInserters
                                 .fromFormData("username", username)
                                 .with("password", "1234")
                                 .with("client_id", clientId)
                                 .with("client_secret", clientSecret)
                                 .with("grant_type", "password")
                 )
                 .retrieve().bodyToMono(KeycloakAuthResponse.class)
                 .block();
  }

  @GetMapping("/ext/polling")
  @ResponseBody
  public CallStatusJWT pollingQrFlow(@RequestParam Map<String, String> raw) {
    log.info("pollingQrFlow, raw: {}", raw);
    final String session = raw.get("session");
    if (jwtMap.containsKey(session)) {
      if (jwtMap.get(session) == null) {
        jwtMap.remove(session);
        return new CallStatusJWT(CallStatus.FAIL, "");
      } else {
        final String accessToken = jwtMap.get(session).getAccessToken();
        jwtMap.remove(session);
        return new CallStatusJWT(CallStatus.SUCCESS, accessToken);
      }
    } else {
      return new CallStatusJWT(CallStatus.WAIT, "");
    }
//
//    if (counter < 5 ||
//            (counter > 5 && counter < 10)
//    ) {
//      counter++;
//      return new CallStatusJWT(CallStatus.WAIT, "");
//    } else if (counter == 5) {
//      counter++;
//      return new CallStatusJWT(CallStatus.SUCCESS,
//              "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZHhwX2ROaWV3MFVUbGFxOVZ3anRpb3I2d3FBdnZhRmlTeDFRUk5fN2pRIn0.eyJleHAiOjE2NTg0MjI4OTEsImlhdCI6MTY1ODQyMjU5MSwianRpIjoiZGQ5MWNmZjctOTYzNS00NGMzLTg2NzEtNzczN2ExYzVhOTU4IiwiaXNzIjoiaHR0cDovLzIwLjEwMy4xODEuMTY2L3JlYWxtcy9nYWlhLXgiLCJzdWIiOiIyZmJkYWMxYi01MmJhLTRkZGYtYWIzOS1mYTdiOWViMThhODEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJnYWlheF9jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiOTMwNGVmMTUtY2Q0Yi00NTg4LTkzMGMtMWI1MjQ3NjQyMGMwIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLWdhaWEteCIsImdhaWF4LXBwciJdfSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiOTMwNGVmMTUtY2Q0Yi00NTg4LTkzMGMtMWI1MjQ3NjQyMGMwIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiUm9zcyBHZWxsZXIiLCJsb2NhdGlvbiI6Ikdlcm1hbnkiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJnYWlheF9wcHJfMSIsImdpdmVuX25hbWUiOiJSb3NzIiwiZmFtaWx5X25hbWUiOiJHZWxsZXIiLCJlbWFpbCI6InJvc3NAZ2VsbGVyLmZyIn0.UaCYmU1ZrvDkttB5fFQ865R7i09P7nlOGWz-9fAEKWr6FBXLL_mK5GfIYr2HH35LGlP7hi1Zsd4S5dHDMVAyr6p4KDs7HhLFWcOGyrq9Mjsxp7Ir5ECiJAA833mQNPtgUHRkjiO9OGJgpep9dMNaiSEdvM_34AB0qJsN9-MBbCamUvve_kaoy27xj3qXYbkvrQOjimh0kGEKG7cVbtyTnNpfNENoDHj9pxbdqym0KEZCcPLT9ekhNDGljbWAsWGkSxKVcqn9eLeOMB1OA9hebrcnEpzZsmSQWD48jO-draTfkxWNfIeggbiYAvn3275O7R85mkBxgIeeY82a4LZ1_g");
//
//    } else if (counter == 10) {
//      counter = 1;
//      return new CallStatusJWT(CallStatus.WAIT, "");
//
//    }

//    throw new AssertionError("Never goes here");
  }

  @GetMapping(value = "/register/user/vc")
  @ResponseBody
  public ResponseEntity requestUserVC(
          HttpServletRequest request
  ) {
    log.info("We should already have JWT because user scanned QR code and was authorized");

    // Two scenarious are possible: first_did is true and the data, first_did is false and no data
    final String jwt = request.getHeader("Authorization");

    if (jwt == null || jwt.isBlank()) {
      log.info("no JWT provided");
      return ResponseEntity
              .status(HttpStatus.UNAUTHORIZED)
              .body(new ErrorDto("/api/onboarding/register/user/vc", "Not authorized"));
    } else {
      final JSONObject json = JwtUtil.readTokenIntoClass(jwt);
      log.info("json: {}", json);
      final String prefUserName = json.getString("preferred_username");
      if (prefUserName.equals("gaiax-pcr-first-did")) {
        log.info("First DID - valid for onboarding");
        return ResponseEntity.ok().body(
                new UserVCDTO(
                        new UserRegistrationRequest(
                                json.getString("name"),
                                json.getString("family_name"),
                                json.getString("email"),
                                json.getString("prPhone"),
                                json.getJSONObject("address").getString("street_address"),
                                json.getJSONObject("address").getString("postal_code"),
                                json.getJSONObject("address").getString("locality"),
                                json.getJSONObject("address").getString("country")
                        ),
                        true
                )
        );
      } else if (prefUserName.equals("gaiax-pcr")) {
        log.info("Customer already onboarded");
        return ResponseEntity.ok().body(new NoVCDTO());
      }
    }

    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(new ErrorDto("/api/onboarding/register/user/vc", "Incorrect auth data"));


  }

  @GetMapping(value = "/register/organization/vc")
  @ResponseBody
  public ResponseEntity requestOrganizationVC(
          HttpServletRequest request
  ) {
    log.info("We should already have JWT because user scanned QR code and was authorized");

    // Two scenarious are possible: first_did is true and the data, first_did is false and no data
    final String jwt = request.getHeader("Authorization");

    if (jwt == null || jwt.isBlank()) {
      log.info("no JWT provided");
      return ResponseEntity
              .status(HttpStatus.UNAUTHORIZED)
              .body(new ErrorDto("/api/onboarding/register/organization/vc", "Not authorized"));
    } else {
      final JSONObject json = JwtUtil.readTokenIntoClass(jwt);
      log.info("json: {}", json);
      final String prefUserName = json.getString("preferred_username");
      if (prefUserName.equals("gaiax-ppr-first-did")) {
        log.info("First DID - valid for onboarding");
        return ResponseEntity.ok().body(
                new OrganizationVCDTO(
                        new OrganizationRegistrationRequest(
                                json.getString("prName"),
                                json.getString("prEmail"),
                                true,                                            // not in JWT
                                json.getString("prPhone"),
                                json.getJSONObject("address").getString("street_address"),
                                json.getJSONObject("address").getString("postal_code"),
                                json.getJSONObject("address").getString("locality"),
                                json.getJSONObject("address").getString("country")
                        ),
                        true
                )
        );
      } else if (prefUserName.equals("gaiax-ppr")) {
        log.info("Provider already onboarded");
        return ResponseEntity.ok().body(new NoVCDTO());
      }
    }

    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(new ErrorDto("/api/onboarding/register/organization/vc", "Incorrect auth data"));

  }

  @GetMapping("/idp")
  public List<IDP> idpListForOrganization() {
    return List.of(
            new IDP("https://cdn.icon-icons.com/icons2/2699/PNG/512/atlassian_jira_logo_icon_170511.png",
                    "Provider 1",
                    "https://www.data-infrastructure.eu"
            ), new IDP("https://cdn.icon-icons.com/icons2/2699/PNG/512/atlassian_jira_logo_icon_170511.png",
                    "Provider 2",
                    "https://www.data-infrastructure.eu"
            ), new IDP("https://cdn.icon-icons.com/icons2/2699/PNG/512/atlassian_jira_logo_icon_170511.png",
                    "Provider 3",
                    "https://www.data-infrastructure.eu"
            ), new IDP("https://cdn.icon-icons.com/icons2/2699/PNG/512/atlassian_jira_logo_icon_170511.png",
                    "Provider 4",
                    "https://www.data-infrastructure.eu"
            ), new IDP("https://cdn.icon-icons.com/icons2/2699/PNG/512/atlassian_jira_logo_icon_170511.png",
                    "Provider 5",
                    "https://www.data-infrastructure.eu"
            )
    );
  }

  @GetMapping("/qr")
  @ResponseBody
  public QrInfoResponse qrFlow() {
    final String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
    return getQrInfoResponse(uriExternal, sessionId);
  }

  public static QrInfoResponse getQrInfoResponse(final String uri, final String session) {
    return new QrInfoResponse(
            String.format("%s%s?session=%s", uri, "/demo/api/onboarding/ext/polling", session),
            String.format("%s%s?session=%s", uri, "/demo/api/identity/mock_qr_link", session),
            String.format("%s%s?session=%s", uri.replaceFirst("^http.*//", "wallet://"), "/demo/api/identity" +
                    "/mock_qr_link", session)
    );
  }
}

package eu.gaia_x.demo.web.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AuthController {

//  @GetMapping("${services.edge.uri_path.auth-status}")
//  @ResponseBody
//  public ResponseEntity<?> getAuthStatus(@Value("${services.identity.client-id}") String clientId) {
//    @SuppressWarnings("unchecked") final AuthTokenResponse authTokenResponse = AuthTokenResponse.from(
//            Objects.requireNonNull(webClientIdentity.post()
//                                                    .uri(accessTokenPath)
//                                                    .body(Mono.just(
//                                                            AuthStatusParameters.of(
//                                                                    clientId,
//                                                                    Optional.ofNullable(userSessionState.getDeviceCode())
//                                                                            .orElse("DEVICE_CODE"),
//                                                                    RequestContextHolder.currentRequestAttributes().getSessionId()
//                                                            ).map()
//                                                    ), Map.class)
//                                                    .retrieve().bodyToMono(Map.class)
//                                                    .block()));
//    log.info("getAuthStatus, token response: {}", authTokenResponse);
//
//    return new ResponseEntity<>(authTokenResponse.getStatus(), HttpStatus.OK);
//  }
}

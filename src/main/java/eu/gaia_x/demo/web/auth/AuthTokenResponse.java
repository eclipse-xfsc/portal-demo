package eu.gaia_x.demo.web.auth;

import eu.gaia_x.demo.web.common.CallStatus;
import lombok.Value;

import java.util.Map;

@SuppressWarnings("unused")
@Value(staticConstructor = "of")
public class AuthTokenResponse {
  String state;
  String accessToken;
  CallStatus status;

  public static AuthTokenResponse from(Map<String, String> m) {
    return of(m.get("state"), m.get("accessToken"), CallStatus.valueOf(m.get("status")));
  }
}

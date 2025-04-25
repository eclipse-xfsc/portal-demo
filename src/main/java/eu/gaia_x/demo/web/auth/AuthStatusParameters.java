package eu.gaia_x.demo.web.auth;

import lombok.NonNull;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Value(staticConstructor = "of")
public class AuthStatusParameters {
  @NonNull String clientId;
  @NonNull String deviceCode;
  @NonNull String state;

  public static AuthStatusParameters from(Map<String, String> m) {
    return of(
            m.getOrDefault("clientId", "123321"),
            m.getOrDefault("deviceCode", "12345"),
            m.getOrDefault("state", "314159265358"));
  }

  public Map<String, String> map() {
    final Map<String, String> m = new HashMap<>();
    m.put("clientId", clientId);
    m.put("deviceCode", deviceCode);
    m.put("state", state);

    return m;
  }
}


package eu.gaia_x.demo.web.email;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@ToString
@Value(staticConstructor = "of")
public class EmailConfirmationParameters {
  @NonNull
  String email;

  @NonNull
  String state;

  @NonNull
  String redirectURI;

  public static EmailConfirmationParameters from(Map<String, String> m) {
    return of(m.get("email"), m.get("state"), m.get("redirect_uri"));
  }

  public Map<String, String> map() {
    final Map<String, String> m = new HashMap<>();
    m.put("email", email);
    m.put("state", state);
    m.put("redirect_uri", redirectURI);

    return m;
  }
}

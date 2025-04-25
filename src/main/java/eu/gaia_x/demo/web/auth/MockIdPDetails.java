package eu.gaia_x.demo.web.auth;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@ToString
@Value(staticConstructor = "of")
public class MockIdPDetails {
      @NonNull
      String name;

      @NonNull
      String link;

      @NonNull
      String logo_uri;

      public static MockIdPDetails from(Map<String, String> m) {
        return of(m.get("name"), m.get("link"), m.get("logo_uri"));
      }

      public Map<String, String> map() {
        final Map<String, String> m = new HashMap<>();
        m.put("name", name);
        m.put("link", link);
        m.put("logo_uri", logo_uri);
        return m;
      }
}
package eu.gaia_x.demo.web.vc;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@ToString
@Value(staticConstructor = "of")
public class MockVCOrganization {
      @NonNull
      String email;

      @NonNull
      String name;

      @NonNull
      String phoneNumber;

      @NonNull
      String streetAndNumber;

      @NonNull
      String zip;

      @NonNull
      String city;

      public static MockVCOrganization from(Map<String, String> m) {
        return of(m.get("email"), m.get("name"), m.get("phoneNumber"), m.get("streetAndNumber"), m.get("zip"), m.get("city"));
      }

      public Map<String, String> map() {
        final Map<String, String> m = new HashMap<>();
        m.put("email", email);
        m.put("name", name);
        m.put("phone_number", phoneNumber);
        m.put("street_number", streetAndNumber);
        m.put("zip", zip);
        m.put("city", city);
        return m;
      }
}
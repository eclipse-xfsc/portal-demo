package eu.gaia_x.demo.onboarding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.gaia_x.demo.web.common.CallStatus;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CallStatusJWT {
  @NonNull
  private CallStatus status;
  @JsonProperty(value = "access_token")
  private String accessToken;
}

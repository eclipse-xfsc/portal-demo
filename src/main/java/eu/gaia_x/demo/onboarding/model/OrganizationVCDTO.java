package eu.gaia_x.demo.onboarding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationVCDTO {
  OrganizationRegistrationRequest vc;
  @JsonProperty("first_did")
  @NonNull Boolean firstDID;
}

package eu.gaia_x.demo.onboarding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class NoVCDTO {
  @JsonProperty("first_did")
  @NonNull boolean firstDID = false;
}
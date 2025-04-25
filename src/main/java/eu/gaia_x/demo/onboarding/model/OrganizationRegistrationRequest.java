package eu.gaia_x.demo.onboarding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * ...
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationRegistrationRequest implements Serializable {

  @JsonProperty(value = "name", required = true)
  private String name;

  @JsonProperty(value = "email", required = true)
  private String email;

  @JsonProperty(value = "aisbl", required = true)
  private boolean aisbl;

  @JsonProperty(value = "phone_number", required = true)
  private String phoneNumber;

  @JsonProperty(value = "street_number", required = true)
  private String streetAndNumber;

  @JsonProperty(value = "zip", required = true)
  private String zip;

  @JsonProperty(value = "city", required = true)
  private String city;

  @JsonProperty(value = "country", required = true)
  private String country;
}

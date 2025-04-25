package eu.gaia_x.demo.onboarding.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class IDP {
  @NonNull private String logoUrl;
  @NonNull private String name;
  @NonNull private String link;
}

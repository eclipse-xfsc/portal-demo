package eu.gaia_x.demo.discovery.dto.chips;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class ChipsEntry {
  @NonNull
  String label;

  @NonNull
  String term;
}

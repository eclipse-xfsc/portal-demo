package eu.gaia_x.demo.storage;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@ToString
@NoArgsConstructor
public class EmailConfirmationStorage {
  final private Map<String, Boolean> m = new HashMap<>();

  public void confirmEmail(String email) {
    m.merge(email, Boolean.TRUE, (x, y) -> Boolean.TRUE);
  }

  public void addEmail(String email) {
    m.put(email, Boolean.FALSE);
  }

  public Boolean isConfirmed(String email) {
    return m.getOrDefault(email, Boolean.FALSE);
  }
}

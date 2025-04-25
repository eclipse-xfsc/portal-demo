package eu.gaia_x.demo.discovery.rand;

import lombok.NonNull;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.MultiValueMap;

import java.util.*;

@Log4j2
@Value(staticConstructor = "of")
public class AllInfoFromServiceId {
  @NonNull String pprId;
  @NonNull String serviceType;
  @NonNull int nbrOfSlots;
  @NonNull List<String> depsIds;
  @NonNull boolean isChild;
  @NonNull boolean isIncludedInComposite;
  @NonNull int nbrOfAvailable;
  @NonNull int slotId;
  @NonNull Map<Integer, List<String>> depsIdsPerSlot;

  public static AllInfoFromServiceId getAllInfoFromServiceId(final String serviceId) {
    return AllInfoFromServiceId.of(
            determinePPRIdByServiceId(serviceId),
            determineServiceType(serviceId),
            nbrOfSlotsByServiceId(serviceId),
            generateDepsIds(serviceId),
            isChild(serviceId),
            isIncludedInComposite(serviceId),
            determineNumberOfAvailableForChild(serviceId),
            determineSlotId(serviceId),
            determineDepsIdsPerSlot(serviceId)
    );
  }

  private static Map<Integer, List<String>> determineDepsIdsPerSlot(final String serviceId) {
    final Map<Integer, List<String>> m = new HashMap<>();

    if (!isChild(serviceId)) {
      for (final String childId : generateDepsIds(serviceId)) {
        final int key = determineSlotId(childId);
        final List<String> val = m.getOrDefault(key, new ArrayList<>());
        val.add(childId);
        m.put(key, val);
      }
    }

    return m;
  }

  private static int determineSlotId(final String serviceId) {
    if (isChild(serviceId)) {
      return preLastDigit(serviceId);
    } else {
      return 0;
    }
  }

  private static String determineParentServiceId(final String serviceId) {
    if (isChild(serviceId)) {
      final String[] splitted = serviceId.split("-");
      return String.format("%s-%s", splitted[0], splitted[1]);
    } else {
      return serviceId;
    }
  }

  private static int determineNumberOfAvailableForChild(final String serviceId) {
    if (isChild(serviceId)) {
      return getPreLastDigit(serviceId);
    } else {
      return 0;
    }
  }

  private static int getPreLastDigit(final String serviceId) {
    return preLastDigit(serviceId);
  }

  private static boolean isIncludedInComposite(final String serviceId) {
    if (isChild(serviceId)) {
      if (determineSlotId(serviceId) % 2 == 0) {
        return false;
      } else {
        return preLastDigit(serviceId) == lastDigit(serviceId);
      }
    } else {
      return false;
    }
  }

  private static boolean isChild(final String serviceId) {
    return serviceId.split("-").length > 2;
  }

  private static List<String> generateDepsIds(final String serviceId) {
    if (!isChild(serviceId)) {

      final String parent = determineParentServiceId(serviceId);
      final List<String> l = new ArrayList<>();
      final int nbrOfSlots = nbrOfSlotsByServiceId(parent);
      for (int i = 1; i <= nbrOfSlots; ++i) {
        for (int j = 1; j <= i; ++j) {
          l.add(String.format("%s-%d%d", parent, i, j));
        }
      }

      return l;
    } else {
      return Collections.emptyList();
    }
  }

  /*
  We assume that ID is an integer represented as String. Integer - because that is easy to mock the algorithms,
  "as String" - in order do not rely on integers. Later on we can easily add any prefix/suffix as a character
  and verify that it is really a String but re-use mathematics.
   */
  private static String determinePPRIdByServiceId(final String serviceId) {
    return serviceId.substring(0, serviceId.indexOf("-"));
  }

  private static int nbrOfSlotsByServiceId(final String serviceId) {
    if (!isChild(serviceId)) {
      final String parent = determineParentServiceId(serviceId);
      if (determineServiceType(parent).equals("composite-service")) {
        return lastDigit(parent) + 1;
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }

  private static String determineServiceType(final String serviceId) {
    int lastDigit = lastDigit(determineParentServiceId(serviceId));

    return (lastDigit == 3 || lastDigit == 5) ? "composite-service" : "service";
  }

  public static int lastDigit(final String baseId) {
    return Integer.parseInt(baseId.substring(baseId.length() - 1));
  }

  public static int preLastDigit(final String baseId) {
    return Integer.parseInt(baseId.substring(baseId.length() - 2, baseId.length() - 1));
  }
}

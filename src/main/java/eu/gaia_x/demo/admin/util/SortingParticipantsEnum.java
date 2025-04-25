package eu.gaia_x.demo.admin.util;

import eu.gaia_x.demo.admin.dto.PartItem;

import java.util.Arrays;
import java.util.Comparator;

public enum SortingParticipantsEnum {
    PARTICIPANT_NAME_ASC("participant_name", "ASC", Comparator.comparing(PartItem::getParticipantName)),
    PARTICIPANT_NAME_DESC("participant_name", "DESC", (p1, p2) -> p1.getParticipantName().compareTo(p2.getParticipantName()) * (-1));

    private final String param;
    private final String direction;
    private final Comparator<PartItem> comparator;

    SortingParticipantsEnum(String param, String direction, Comparator<PartItem> comparator) {
        this.param = param;
        this.direction = direction;
        this.comparator = comparator;
    }

    public static Comparator<PartItem> getComparatorByParam(String param, String direction) {
        return Arrays.stream(values())
                .filter(x -> x.param.equalsIgnoreCase(param))
                .filter(x -> x.direction.equalsIgnoreCase(direction))
                .findFirst()
                .orElse(PARTICIPANT_NAME_ASC)
                .comparator;
    }
}

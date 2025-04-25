package eu.gaia_x.demo.utils;

import org.springframework.util.StringUtils;

public enum PagingEnum {
    FIRST,
    PREV,
    NEXT;

    public static PagingEnum getByName(String name) {
        if (!StringUtils.hasText(name)) return FIRST;
        return valueOf(name);
    }
}

package eu.gaia_x.demo.discovery.dto.search;

public enum SearchResultEnum {
    DATA("data"),
    PPR("ppr"),
    SERVICE("services");

    private final String paramValue;

    SearchResultEnum(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}

package eu.gaia_x.demo.lcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ServicesResponse {
    @JsonProperty(value = "services", required = true)
    private ServiceOverviewDto[] services;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ServiceOverviewDto {
        @JsonProperty(value = "serviceId", required = true)
        private String serviceId;
        @JsonProperty(value = "serviceName", required = true)
        private String serviceName;
        @JsonProperty(value = "applicableLcm", required = true)
        private ApplicableLcm[] applicableLcm;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ApplicableLcm {
        @JsonProperty(value = "id", required = true)
        private String id;
        @JsonProperty(value = "name", required = true)
        private String name;
        @JsonProperty(value = "description", required = true)
        private String description;
    }
}

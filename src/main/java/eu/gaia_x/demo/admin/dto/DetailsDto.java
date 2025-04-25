package eu.gaia_x.demo.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailsDto {
    @JsonProperty(value = "sd_data", required = true)
    private List<SdData> sdDataList;
    @JsonProperty(value = "attachments", required = true)
    private List<AttachmentDto> attachments;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class AttachmentDto {
        @JsonProperty(value = "name", required = true)
        private String name;
        @JsonProperty(value = "description", required = true)
        private String description;
        @JsonProperty(value = "url", required = true)
        private String url;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SdData {
        @JsonProperty(value = "name", required = true)
        private String name;
        @JsonProperty(value = "attributes", required = true)
        private List<Attribute> attributes;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Attribute {
        @JsonProperty(value = "name", required = true)
        private String name;
        @JsonProperty(value = "value", required = true)
        private String value;
        @JsonProperty(value = "mandatory", required = true)
        private boolean mandatory;
    }
}

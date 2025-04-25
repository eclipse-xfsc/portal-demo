package eu.gaia_x.demo.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MockData {
    List<String> location;
    @SerializedName("location-flag")
    List<String> locationFlag;
    @SerializedName("preview-img")
    List<String> previewImg;
    List<String> description;
    List<String> tags;
    List<String> logo;
    @SerializedName("company-url")
    List<String> companyUrl;
    @SerializedName("ppr-name")
    List<String> pprName;
    @SerializedName("participant-name")
    List<String> participantName;
    @SerializedName("registration-type")
    List<String> registrationType;
    @SerializedName("request-type")
    List<String> requestType;
    @SerializedName("location-country")
    List<String> locationCountry;
}

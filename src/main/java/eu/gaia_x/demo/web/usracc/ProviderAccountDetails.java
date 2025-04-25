package eu.gaia_x.demo.web.usracc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderAccountDetails implements Serializable {

    @JsonProperty(value = "avatarImageLink", required = true)
    private String avatarImageLink;

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "companyName", required = true)
    private String companyName;

    @JsonProperty(value = "commercialRegister", required = true)
    private String commercialRegister;

    @JsonProperty(value = "registeredAddress", required = true)
    private String registeredAddress;

    @JsonProperty(value = "webAddress", required = true)
    private String webAddress;

    @JsonProperty(value = "individualContact", required = true)
    private IndividualContact individualContact;

    @JsonProperty(value = "certification", required = true)
    private String certification;

    @JsonProperty(value = "alias", required = true)
    private String alias;

    @JsonProperty(value = "localAttestation", required = true)
    private String localAttestation;

    @JsonProperty(value = "transparencyRegister", required = true)
    private String transparencyRegister;

    @JsonProperty(value = "dunsNumber", required = true)
    private String dunsNumber;

    @JsonProperty(value = "legalEntityIdentifier", required = true)
    private String legalEntityIdentifier;

    @JsonProperty(value = "dataProviderOfficer", required = true)
    private DataProviderOfficer dataProviderOfficer;
}

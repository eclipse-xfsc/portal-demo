package eu.gaia_x.demo.web.usracc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserAccountDetails implements Serializable {

    @JsonProperty(value = "avatarImageLink", required = true)
    private String avatarImageLink;

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "surname", required = true)
    private String surname;

    @JsonProperty(value = "attributeA", required = true)
    private String attributeA;

    @JsonProperty(value = "attributeB", required = true)
    private String attributeB;

    @JsonProperty(value = "attributeC", required = true)
    private String attributeC;

    public UserAccountDetails(String avatarImageLink, String email, String name, String surname, String attributeA, String attributeB, String attributeC) {
        this.avatarImageLink = avatarImageLink;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.attributeA = attributeA;
        this.attributeB = attributeB;
        this.attributeC = attributeC;
    }

    public UserAccountDetails() {
        //
    }

    public String getAvatarImageLink() {
        return avatarImageLink;
    }

    public void setAvatarImageLink(String avatarImageLink) {
        this.avatarImageLink = avatarImageLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAttributeA() {
        return attributeA;
    }

    public void setAttributeA(String attributeA) {
        this.attributeA = attributeA;
    }

    public String getAttributeB() {
        return attributeB;
    }

    public void setAttributeB(String attributeB) {
        this.attributeB = attributeB;
    }
    public String getAttributeC() {
        return attributeC;
    }

    public void setAttributeC(String attributeC) {
        this.attributeC = attributeC;
    }

}

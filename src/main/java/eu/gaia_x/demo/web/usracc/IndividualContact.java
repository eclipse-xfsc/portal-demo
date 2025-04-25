package eu.gaia_x.demo.web.usracc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class IndividualContact implements Serializable {

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "surname", required = true)
    private String surname;

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "phoneNumber", required = true)
    private String phoneNumber;

    public IndividualContact(String name, String surname, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public IndividualContact() {
        //
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package com.readlearncode.model;

import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Objects;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@Named
@FacesConfig(version = JSF_2_3)
public class Client {

    private Integer id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @Past
    @NotNull
    private Date dob; // Date Of Birth

    @AssertTrue
    private Boolean acceptTOS; // Have the Terms Of Service been accepted

    @NotNull
    private String creditCardNumber;

    public Client() {
    }

    public Client(Integer id, String name, Date dob, String email, String confirmEmail, Boolean acceptTOS, String creditCardNumber) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.acceptTOS = acceptTOS;
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAcceptTOS() {
        return acceptTOS;
    }

    public void setAcceptTOS(Boolean acceptTOS) {
        this.acceptTOS = acceptTOS;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(dob, client.dob) &&
                Objects.equals(acceptTOS, client.acceptTOS) &&
                Objects.equals(creditCardNumber, client.creditCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, dob, acceptTOS, creditCardNumber);
    }
}
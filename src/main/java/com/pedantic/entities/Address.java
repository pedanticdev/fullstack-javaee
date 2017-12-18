/**
 * This file was generated by the Jeddict
 */
package com.pedantic.entities;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author pedantic
 */
@Embeddable
public class Address {

    @Basic
    @NotNull(message = "Street address cannot be blank")
    private String street;

    @Basic
    @NotNull(message = "Telephone number must be set")
    private String tel;

    @Basic
    private String city;

    @Basic
    private String stateName;

    @Basic
    @NotNull(message = "Zip code must be set")
    private String zipCode;

    @Basic
    @NotNull(message = "Country must be set")
    private String country;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
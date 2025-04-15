package io.flexwiz.orp.sample.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

    private String street;
    private String zipCode;
    private String city;
    // Country code (ISO 3166)
    private String country;

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public Address street(String street)
    {
        setStreet(street);
        return this;
    }

    public String getZipCode()
    {
        return this.zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public Address zipCode(String zipCode)
    {
        setZipCode(zipCode);
        return this;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Address city(String city)
    {
        setCity(city);
        return this;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Address country(String country)
    {
        setCountry(country);
        return this;
    }

	@Override
	public String toString() {
		return "Address [street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}
}

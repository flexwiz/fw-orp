package fr.ntdt.ezloc.immo.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AddressDto implements Serializable {
	
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

    public AddressDto street(String street) 
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

    public AddressDto zipCode(String zipCode) 
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

    public AddressDto city(String city) 
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

    public AddressDto country(String country) 
    {
        setCountry(country);
        return this;
    }

	@Override
	public String toString() {
		return "AddressDto [street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}
}
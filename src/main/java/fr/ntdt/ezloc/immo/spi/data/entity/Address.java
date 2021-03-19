package fr.ntdt.ezloc.immo.spi.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
@Entity
public class Address extends AbstractDatedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Column(nullable = false, length = 250)
    private String street;

    @Column(nullable = false, length = 10)
    private String zipCode;

    @Column(nullable = false, length = 120)
    private String city;
    
    // Country code (ISO 3166)
    @Column(nullable = false, length = 2)
    private String country;

    /**
     * Create new address with a random ID
     */
    public Address() {
        super();
    }

    /**
     * Create new address with all information
     * 
     * @param street address street
     * @param zipCode zip code
     * @param city city
     * @param country country iso code
     */
    public Address(String street, String zipCode, String city, String country) {
        super();
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

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
		return "Address [" + super.toString() + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (!super.equals(other))
			return false;
		
		return hashCode() == other.hashCode();
	}
}
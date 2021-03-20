package fr.ntdt.ezloc.immo.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class RealEstate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    public static enum Type {
        HOUSE,
        BUILDING,
        APARTMENT
    };

    @NonNull
    private Type type;
    private String title;
    private String description;
    private Address address;

    public Type getType() 
    {
        return this.type;
    }

    public void setType(Type type) 
    {
        this.type = type;
    }

    public RealEstate type(Type type)
    {
        setType(type);
        return this;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public RealEstate address(Address address)
    {
        setAddress(address);
        return this;
    }

    public String getTitle() 
    {
        return this.title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public RealEstate title(String title)
    {
        setTitle(title);
        return this;
    }

    public String getDescription() 
    {
        return this.description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public RealEstate description(String description)
    {
        setDescription(description);
        return this;
    }

	@Override
	public String toString() {
		return "RealEstate [type=" + type + ", title=" + title + ", address=" + address + "]";
	}
}
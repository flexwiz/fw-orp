package fr.ntdt.ezloc.immo.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class RealEstateDto implements Serializable {
	
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
    private AddressDto address;

    public Type getType() 
    {
        return this.type;
    }

    public void setType(Type type) 
    {
        this.type = type;
    }

    public RealEstateDto type(Type type) 
    {
        setType(type);
        return this;
    }

    public AddressDto getAddress() 
    {
        return this.address;
    }

    public void setAddress(AddressDto address) 
    {
        this.address = address;
    }

    public RealEstateDto address(AddressDto address) 
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

    public RealEstateDto title(String title) 
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

    public RealEstateDto description(String description) 
    {
        setDescription(description);
        return this;
    }

	@Override
	public String toString() {
		return "RealEstateDto [type=" + type + ", title=" + title + ", address=" + address + "]";
	}
}
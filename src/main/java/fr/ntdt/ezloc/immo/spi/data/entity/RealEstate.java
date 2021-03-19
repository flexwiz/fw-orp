package fr.ntdt.ezloc.immo.spi.data.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
@Entity
public class RealEstate extends AbstractDatedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    public static enum Type {
        HOUSE,
        BUILDING,
        APARTMENT
    };

    private Type type;
    private String title;
    private Address address;
    private String description;

    private List<Equipment> equipments;

    /**
     * Create new real estate with a random ID
     */
    public RealEstate() {
        super();
    }

    /**
     * Create new real estate with a random ID and a type
     * 
     * @param type a real estate type
     */
    public RealEstate(Type type) {
        super();
        this.type = type;
    }

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

    public List<Equipment> getEquipments() 
    {
        return this.equipments;
    }

    public void setEquipments(List<Equipment> equipments) 
    {
        this.equipments = equipments;
    }

    public RealEstate equipments(List<Equipment> equipments) 
    {
        setEquipments(equipments);
        return this;
    }

    public void addEquipment(Equipment equipment) { 
        if (this.equipments == null)
            this.equipments = Arrays.asList(equipment);
        else
            this.equipments.add(equipment); 
    }

    public void removeEquipment(Equipment equipment) { 
        if (this.equipments != null)
            this.equipments.remove(equipment);
    }

    public void removeAllEquipments() {
		this.equipments.clear();
    }

	@Override
	public String toString() {
		return "RealEstate [" + super.toString() + ", type=" + type + ", title=" + title + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		RealEstate other = (RealEstate) obj;

		return hashCode() == other.hashCode();
	}
}
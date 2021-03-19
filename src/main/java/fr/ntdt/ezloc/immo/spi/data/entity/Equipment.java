package fr.ntdt.ezloc.immo.spi.data.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
@Entity
public class Equipment extends AbstractDatedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Column(nullable = false, length = 25)
    private String serialNumber;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 25)
    private String type;

    // Date of the appropriate equipment is installed
    @Column(nullable = false)
    private OffsetDateTime installedDate;

    // Date of the last revision
    @Column(nullable = true)
    private OffsetDateTime lastRevision;

    // Comments
    @Column(length = 1024)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "real_estate_id", nullable = false)
    private RealEstate realEstate;

    /**
     * Create new equipment with a random ID
     */
    public Equipment() {
        super();
    }

    /**
     * Create new equipment with all information
     * 
     * @param name name
     * @param type type of equipment
     * @param serialNumber serial number
     */
    public Equipment(String name, String type, String serialNumber) {
        super();
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public Equipment serialNumber(String serialNumber) 
    {
        setSerialNumber(serialNumber);
        return this;
    }

    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public Equipment name(String name) 
    {
        setName(name);
        return this;
    }

    public String getType() 
    {
        return this.type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public Equipment type(String type) 
    {
        setType(type);
        return this;
    }

    public OffsetDateTime getInstalledDate() 
    {
        return this.installedDate;
    }

    public void setInstalledDate(OffsetDateTime installedDate) 
    {
        this.installedDate = installedDate;
    }

    public Equipment installedDate(OffsetDateTime installedDate) 
    {
        setInstalledDate(installedDate);
        return this;
    }

    public OffsetDateTime getLastRevision() 
    {
        return this.lastRevision;
    }

    public void setLastRevision(OffsetDateTime lastRevision) 
    {
        this.lastRevision = lastRevision;
    }

    public Equipment lastRevision(OffsetDateTime lastRevision) 
    {
        setLastRevision(lastRevision);
        return this;
    }

    public String getComment() 
    {
        return this.comment;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public Equipment comment(String comment) 
    {
        setComment(comment);
        return this;
    }

	@Override
	public String toString() {
		return "Address [" + super.toString() + ", serialNumber=" + serialNumber + ", name=" + name + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
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
		Equipment other = (Equipment) obj;

        return hashCode() == other.hashCode();
	}
}
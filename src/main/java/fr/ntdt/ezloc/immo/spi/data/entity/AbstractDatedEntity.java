package fr.ntdt.ezloc.immo.spi.data.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

// @MappedSuperclass
@Entity
public abstract class AbstractDatedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY) 
	// private Long id;
	
    @Id
    protected UUID id;
    protected UUID createdByUserId;
    protected OffsetDateTime dateCreated;
    protected OffsetDateTime lastUpdated;

    /**
     * Create new entity with a random ID
     */
    protected AbstractDatedEntity() {
        this.id = UUID.randomUUID();
    }

    /**
     * 
     * @return the internal entity identifier
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Set an internal entity identifier
     * @param id internal entity identifier
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return the User identifier
     */
    public UUID getUserId() {
        return createdByUserId;
    }

    /**
     * Set user identifier who create the entity
     * @param createdByUserId an user identifier
     */
    public void setUserId(UUID createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    /**
     * @return the dateCreated
     */
    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    /**
     * Set created date
     * @param dateCreated the created date to set
     */
    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @PrePersist
    public void prePersist() {
        this.dateCreated = OffsetDateTime.now();
        this.lastUpdated = this.dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }


	@Override
	public String toString() {
		return "id=" + id + "dateCreated=" + dateCreated + ", lastUpdated="
				+ lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((createdByUserId == null) ? 0 : createdByUserId.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
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
		AbstractDatedEntity other = (AbstractDatedEntity) obj;
		return hashCode() == other.hashCode();
	}
}
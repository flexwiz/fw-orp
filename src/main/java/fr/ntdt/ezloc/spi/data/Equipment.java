package fr.ntdt.ezloc.spi.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Entity
public class Equipment extends Auditable {

    public String serialNumber;
    public String name;
    public String type;
    public String comment;
    public OffsetDateTime installedAt;
    public OffsetDateTime lastRevisitedAt;
    @ManyToOne
    @JoinColumn(
            name = "real_estate_id",
            referencedColumnName = "id",
            nullable = false)
    @JsonBackReference
    public RealEstate realEstate;

}

package io.flexwiz.orp.spi.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class RealEstate extends Auditable {

    @Column(nullable = false, updatable = false)
    public Long ownerId;

    @Column(unique = true, nullable = false, length = 50)
    public String title;

    @Column(nullable = false, length = 1024)
    public String description;

    @Enumerated(EnumType.STRING)
    public Type type;

    @Embedded
    public Address address;

    @OneToMany(
            targetEntity = Equipment.class,
            mappedBy = "realEstate",
            cascade = CascadeType.PERSIST
    )
    @JsonManagedReference
    public List<Equipment> equipments;

}

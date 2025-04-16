package io.flexwiz.orp.spi.data;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String street;
    private String zipcode;
    private String city;
    private String country;
}

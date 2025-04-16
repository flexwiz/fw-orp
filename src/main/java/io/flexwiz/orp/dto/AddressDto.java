package io.flexwiz.orp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class AddressDto {
    @NotBlank
    private String street;
    @Pattern(regexp = "\\d{5}")
    private String zipcode;
    @NotBlank
    private String city;
    @NotBlank
    private String country = "FRANCE";
}

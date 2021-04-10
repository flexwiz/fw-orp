package fr.ntdt.ezloc.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RealEstateDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @Valid
    private AddressDto address;
    @NotNull
    private RealEstateType type;
}

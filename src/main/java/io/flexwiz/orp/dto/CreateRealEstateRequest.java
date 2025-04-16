package io.flexwiz.orp.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class CreateRealEstateRequest {
    @NotNull
    private Long userId;
    @Valid
    private RealEstateDto realEstate;
}

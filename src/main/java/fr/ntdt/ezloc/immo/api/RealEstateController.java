package fr.ntdt.ezloc.immo.api;

import fr.ntdt.ezloc.immo.service.RealEstateService;
import fr.ntdt.ezloc.immo.service.dto.RealEstateDto;
import fr.ntdt.ezloc.immo.service.mapper.RealEstateMapper;
import fr.ntdt.ezloc.immo.spi.data.IRealEstateRepository;
import fr.ntdt.ezloc.immo.spi.data.entity.RealEstate;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
//@Slf4j
public class RealEstateController {

    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(RealEstateController.class);

    private RealEstateService realEstateService;
    private RealEstateMapper realEstateMapper;

    private static UUID DEFAULT_USER_ID = UUID.randomUUID();

    /**
     * 
     * @param realEstateService
     * @param realEstateMapper
     */
    @Autowired
    public RealEstateController(
            RealEstateService realEstateService,
            RealEstateMapper realEstateMapper) {

        this.realEstateService = realEstateService;
        this.realEstateMapper = realEstateMapper;
    }

    @CrossOrigin
    @PostMapping("/realestates")
    ResponseEntity<UUID> addRealEstate(@RequestBody @Valid RealEstateDto realEstateDto) {
        log.info("Create new real estate request received. [title: {}]", realEstateDto.getTitle());

        try {
            UUID id = realEstateService.createRealEstate(DEFAULT_USER_ID, realEstateDto);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

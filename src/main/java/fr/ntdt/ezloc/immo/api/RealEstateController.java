package fr.ntdt.ezloc.immo.api;

import fr.ntdt.ezloc.immo.service.RealEstateService;
import fr.ntdt.ezloc.immo.service.dto.RealEstate;
import fr.ntdt.ezloc.immo.service.mapper.RealEstateMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/real-estates")
    ResponseEntity<UUID> addRealEstate(
        @RequestBody 
        @Valid RealEstate realEstate) {
        log.info("Create new real estate request received. [title: {}]", realEstate.getTitle());

        try {
            UUID id = realEstateService.createRealEstate(DEFAULT_USER_ID, realEstate);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

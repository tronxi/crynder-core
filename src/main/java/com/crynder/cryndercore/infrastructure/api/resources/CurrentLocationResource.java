package com.crynder.cryndercore.infrastructure.api.resources;

import com.crynder.cryndercore.configuration.security.services.JwtService;
import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.domain.usecases.CreateCurrentLocationUseCase;
import com.crynder.cryndercore.infrastructure.api.dto.CoordinateDTO;
import com.crynder.cryndercore.infrastructure.api.mappers.CoordinateDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
public class CurrentLocationResource {

    private final JwtService jwtService;
    private final CreateCurrentLocationUseCase createCurrentLocationUseCase;
    private final CoordinateDTOMapper coordinateDTOMapper;

    @Autowired
    public CurrentLocationResource(JwtService jwtService,
                                   CreateCurrentLocationUseCase createCurrentLocationUseCase,
                                   CoordinateDTOMapper coordinateDTOMapper) {
        this.jwtService = jwtService;
        this.createCurrentLocationUseCase = createCurrentLocationUseCase;
        this.coordinateDTOMapper = coordinateDTOMapper;
    }

    @PutMapping("/current")
    @PreAuthorize("authenticated")
    public ResponseEntity<Void> save(@RequestBody CoordinateDTO coordinateDTO,
                                     @RequestHeader("authorization") String authorization) {
        String userId = jwtService.retrieveId(authorization);
        Location location = coordinateDTOMapper.map(userId, coordinateDTO);
        createCurrentLocationUseCase.create(location);
        return ResponseEntity.ok().build();
    }
}

package com.crynder.cryndercore.infrastructure.api.mappers;

import com.crynder.cryndercore.domain.models.location.Coordinate;
import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.infrastructure.api.dto.CoordinateDTO;
import org.springframework.stereotype.Component;

@Component
public class CoordinateDTOMapper {

    public Location map(String userId, CoordinateDTO coordinateDTO) {
        Coordinate coordinate = new Coordinate(coordinateDTO.latitude, coordinateDTO.longitude);
        return new Location(userId, coordinate);
    }
}

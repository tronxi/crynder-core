package com.crynder.cryndercore.infrastructure.persistence.mappers;

import com.crynder.cryndercore.domain.models.location.Location;
import com.crynder.cryndercore.infrastructure.persistence.dao.UserDAO;
import com.crynder.cryndercore.infrastructure.persistence.entities.CurrentLocationEntity;
import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CurrentLocationMapper {

    private final UserDAO userDAO;

    @Autowired
    public CurrentLocationMapper(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public CurrentLocationEntity map(Location location) {
        UserEntity userEntity = userDAO.getById(location.getUserId());
        CurrentLocationEntity currentLocationEntity = new CurrentLocationEntity();
        currentLocationEntity.setUser(userEntity);
        currentLocationEntity.setLatitude(location.getCoordinate().getLatitude());
        currentLocationEntity.setLongitude(location.getCoordinate().getLongitude());
        currentLocationEntity.setModificationDate(LocalDate.now());
        return currentLocationEntity;
    }
}
